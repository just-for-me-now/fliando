import React, { useState } from "react";
import axios from "axios";
import Button from '../UI/Button/Button.js';
import Card from '../UI/Card/Card.js'
import './PassengerForm.css';
import Passenger from "./Passenger.js";


const PassengerForm = (props) =>{
    
    return(
        <Card className="flightBox">
            <form className="passengerForm">
                <Passenger />
                <Passenger />
                <Passenger />
            </form>
            <Button className="bookButton">BOOK</Button>

        </Card>    
    )
}

export default PassengerForm;