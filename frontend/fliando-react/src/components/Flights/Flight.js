import Card from "../UI/Card/Card";
import Button from "../UI/Button/Button";
import useFetch from "../UseFetch/UseFetch";
import './Flight.css';
import { useState } from "react";

const Flight = props => {

    const address = `http://localhost:8082/price?flightId=${props.flight.id}&toddlers=0&children=0&adults=1&luggage=0&roundTrip=false`;
    const { data: pricePerAdult } = useFetch(address);
    const [selected, setSelected] = useState(false);

    const handleSelect = () => {
        props.select(props.flight.id);
        setSelected(true);
    }
    
    const handleCancel = () => {
        props.deselect();
        setSelected(false);
    }

    return (
        <Card className="flightBox flight">
            <div className="flight-top"><div className="flight-airline">{props.flight.airline}</div></div>

            <div className="flight-main">
                <div className="flight-itinerary">
                    <div className="flight-origin">{props.origin}</div>
                    <div className="flight-arrow">{"➡"}</div>
                    <div className="flight-destination">{props.destination}</div>
                </div>
                <div className="flight-date">
                    <div className="flight-day">{ props.flight.time.slice(0, 10) }</div>
                    <div className="flight-day">{props.flight.time.slice(11)}</div>
                </div>
            </div>

            <div className="flight-bottom">
            {props.flight.scales ? <div className="flight-scales"> this flight has stopovers</div> : ""}
            <div className="price-per-adult">€ { pricePerAdult ? pricePerAdult : "fetching..."}</div>
            {selected ? <Button onClick={handleCancel}>Cancel</Button> : <Button onClick={handleSelect}>Select</Button>}
            </div>
        </Card>
    )
}

export default Flight;