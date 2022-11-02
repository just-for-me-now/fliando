package com.fliando.book.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fliando.book.controller.IdentityTheftException;
import com.fliando.book.controller.UnknownFlightException;
import com.fliando.book.controller.WrongPriceException;
import com.fliando.book.lib.InternalCommunications;
import com.fliando.book.model.Passenger;
import com.fliando.book.model.ReservationInfo;
import com.fliando.book.repo.IPassengerRepository;
import com.fliando.book.repo.IReservationInfoRepository;

@Service
public class BookService {
	
	private IReservationInfoRepository infoRepo;
	private IPassengerRepository passengerRepo;
	
	public BookService(IReservationInfoRepository infoRepo, IPassengerRepository passengerRepo) {
		this.infoRepo = infoRepo;
		this.passengerRepo = passengerRepo;
	}

	public void checkMakeReservation(ReservationInfo reservationInfo) throws UnknownFlightException, WrongPriceException, IdentityTheftException {
		
		if(reservationInfo == null || reservationInfo.getPassengers() == null) throw new UnknownFlightException();
		
		InternalCommunications.log(String.format("Book - Booking request received for flight id #%d for %d people.", reservationInfo.getFlightId(), reservationInfo.getPassengers().size()));
		
		checkWithTheFlightsServiceIfTheFlightExists(reservationInfo);
		
		checkWithThePriceServiceIfThePriceIsCorrect(reservationInfo);
		
		savePassengerInfo(reservationInfo);
		
		infoRepo.save(reservationInfo);
		
	}

	public List<Passenger> findAllPassengers() {
		
		InternalCommunications.log("Book - Get request received: /passengers");
		
		return (List<Passenger>) passengerRepo.findAll();
	}

	private void checkWithTheFlightsServiceIfTheFlightExists(ReservationInfo reservationInfo) throws UnknownFlightException {
		if(!InternalCommunications.checkFlightExists(reservationInfo.getFlightId())) {
			throw new UnknownFlightException();
		}
	}

	private void checkWithThePriceServiceIfThePriceIsCorrect(ReservationInfo reservationInfo) throws WrongPriceException {
		int toddlers = 0, children = 0, adults = 0;
		
		for(Passenger passenger : reservationInfo.getPassengers()) {
			switch(passenger.age) {
			case TODDLER:
				toddlers++;
				break;
			case CHILD:
				children++;
				break;
			case ADULT:
				adults++;
				break;
			}
		}
		
		if(InternalCommunications.checkPrice(reservationInfo.getFlightId(), toddlers, children, adults, reservationInfo.getLuggage()) != reservationInfo.getPrice()) {
			throw new WrongPriceException();
		}
	}

	private void savePassengerInfo(ReservationInfo reservationInfo) throws IdentityTheftException {
		for(Passenger passenger : reservationInfo.getPassengers()) {
			Optional<Passenger> found = passengerRepo.findById(passenger.getIdCard());
			
			if(!found.isEmpty()) {
				
				if(passenger.getFirstName().equals(found.get().getFirstName()) ||
						passenger.getLastName().equals(found.get().getLastName()) ||
						passenger.getNationality().equals(found.get().getNationality())) {
					throw new IdentityTheftException();
				} else if(passenger.getAge() != found.get().getAge()) {
					passengerRepo.save(passenger);
				}
				
			}else {
				
				passengerRepo.save(passenger);
				
			}
			
		}
	}
	
	
}
