import { useState } from "react";
import Flight from "./Flight";
import FlightFilter from "./FlightFilter";
import useFetch from "../UseFetch/UseFetch";
import './FlightContainer.css';

const FlightContainer = props => {

    const address = `http://localhost:8084/origins/${props.origin}/destinations/${props.destination}/dates/${props.date}`;
    console.log(address)
    const { data } = useFetch(address);
    const [filteredFlights, setFilteredFlights] = useState(null);
    const [selected, setSelected] = useState(null)
    const [filters, setFilters] = useState({})

    const handleSelect = key => {
        setSelected(key);
        applyFilters(key, filters);
    }

    const handleDeselect = () => {
        setSelected(null);
        applyFilters(null, filters);
    }

    const handleFilterBy = (key, value) => {
        const newFilters = {...filters};
        newFilters[key] = value;

        setFilters(newFilters);
        applyFilters(selected, newFilters);
    }

    const applyFilters = (selected, filters) => {
        let f = [...data];
        if(selected != null) {
            f = f.filter(elem => elem.id == selected);
        } else {
            if(filters.scales) f = f.filter(elem => !elem.scales)
            
            if(filters.luggage) f = f.filter(elem => elem.luggage)
            if(filters.airline != null && filters.airline.trim().length > 0) f = f.filter(elem => elem.airline.toLowerCase().includes(filters.airline.trim().toLowerCase()))
        }


        setFilteredFlights(f);
    }

    return (
        <div className="flight-container">
            {selected ? <div /> : <FlightFilter filterBy={handleFilterBy}/>}
            {filteredFlights != null ? filteredFlights.map(elem => <Flight flight={elem} key={elem.id} origin={props.originName} destination={props.destinationName} select={handleSelect} deselect={handleDeselect} />)
                                               : data?.map(elem => <Flight flight={elem} key={elem.id} origin={props.originName} destination={props.destinationName} select={handleSelect} deselect={handleDeselect} />)}
        </div>
    );
}

export default FlightContainer;