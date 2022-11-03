import Card from "../UI/Card/Card";
import Button from "../UI/Button/Button";
import './Flight.css';
import { useState } from "react";

const Flight = props => {

    const [selected, setSelected] = useState(false);

    const handleSelect = () => {
        props.select(props.id);
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
                    <div className="flight-origin">{props.flight.origin}</div>
                    <div className="flight-arrow">{"->"}</div>
                    <div className="flight-destination">{props.flight.destination}</div>
                </div>
                <div className="flight-date">
                    <div className="flight-day">{props.flight.time.date}</div>
                    <div className="flight-day">{props.flight.time.time}</div>
                </div>
            </div>

            <div className="flight-bottom">
            {props.flight.scales ? <div className="flight-scales"> this plane has scales</div> : ""}
            <div className="price-per-adult">€ {props.flight.pricePerAdult}</div>
            {selected ? <Button onClick={handleCancel}>Cancel</Button> : <Button onClick={handleSelect}>Select</Button>}
            </div>
        </Card>
    )
}

export default Flight;