import { useState } from "react";
import Flight from "./Flight";
import FlightFilter from "./FlightFilter";
import './FlightContainer.css';

const FlightContainer = props => {
    
    const [filteredFlights, setFilteredFlights] = useState([props.flights]);

    const handleSelect = key => {
        setFilteredFlights(props.flights.filter(elem => elem.id == key))
    }

    const handleDeselect = () => {
        setFilteredFlights(props.flights);
    }

    const handleFilterBy = (key, value) => {
        // TODO
    }

    if(filteredFlights == undefined || filteredFlights.length == 0) return "";

    return (
        <div className="flight-container">
            <FlightFilter filterBy={handleFilterBy}/>
            {props.flights?.map(f => <Flight flight={f} key={f.id} id={f.id} origin={props.origin} destination={props.destination} select={handleSelect} deselect={handleDeselect} />)}
        </div>
    );
}

export default FlightContainer;