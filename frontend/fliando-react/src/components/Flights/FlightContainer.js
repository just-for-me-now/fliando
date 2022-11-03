import { useState } from "react";
import Flight from "./Flight";
import FlightFilter from "./FlightFilter";
import useFetch from "../UseFetch/UseFetch";
import './FlightContainer.css';

const FlightContainer = props => {

    const address = `http://localhost:8084/origins/${props.origin}/destinations/${props.destination}/dates/${props.date}`;
    const { data } = useFetch(address);
    //const [filteredFlights, setFilteredFlights] = useState([]);

    const handleSelect = key => {
        //setFilteredFlights(props.flights.filter(elem => elem.id == key))
    }

    const handleDeselect = () => {
        //setFilteredFlights(props.flights);
    }

    const handleFilterBy = (key, value) => {
        // TODO
    }

    return (
        <div className="flight-container">
            <FlightFilter filterBy={handleFilterBy}/>
            {data?.map(elem => {
                console.log(elem);
                return <Flight flight={elem} key={elem.id} origin={props.originName} destination={props.destinationName} select={handleSelect} deselect={handleDeselect} />
            })}
        </div>
    );
}

export default FlightContainer;