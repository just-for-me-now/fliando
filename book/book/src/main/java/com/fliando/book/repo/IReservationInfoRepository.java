package com.fliando.book.repo;

import org.springframework.data.repository.CrudRepository;

import com.fliando.book.model.ReservationInfo;

public interface IReservationInfoRepository extends CrudRepository<ReservationInfo,Long> {

}
