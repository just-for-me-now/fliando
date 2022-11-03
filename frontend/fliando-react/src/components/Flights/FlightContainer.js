import { useState } from "react";
import Flight from "./Flight";
import './FlightContainer.css';

const FlightContainer = () => {

    const flights = [
        {
            "id":"1",
            "origin": "Sevilla",
            "destination": "Lisboa",
            "time":{"date":"2022-11-11","time":"11:45"},
            "airline": "Lufthansa",
            "scales": true,
            "pricePerAdult": 50,
        },
        {
            "id":"2",
            "origin": "Valencia",
            "destination": "Chicago",
            "time":{"date":"2022-11-15","time":"13:00"},
            "airline": "Tam",
            "scales": false,
            "pricePerAdult": 50,
        },
        {
            "id":"3",
            "origin": "Sevilla",
            "destination": "Lisboa",
            "time":{"date":"2022-11-11","time":"11:45"},
            "airline": "Lufthansa",
            "scales": true,
            "pricePerAdult": 50,
        },
    ]
    
    const [filteredFlights, setFilteredFlights] = useState(flights);

    const handleSelect = key => {
        setFilteredFlights(flights.filter(elem => elem.id == key))
    }

    const handleDeselect = () => {
        setFilteredFlights(flights);
    }

    return (
        <div className="flight-container">
            {filteredFlights.map(f => 
                <Flight flight={f} key={f.id} id={f.id} select={handleSelect} deselect={handleDeselect} />
            )}
        </div>
    );
}

export default FlightContainer;