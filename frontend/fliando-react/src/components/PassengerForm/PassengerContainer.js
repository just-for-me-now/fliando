import React, {useState} from "react";

import Passenger from "./Passenger";
import PassengerButton from "./PassengerButton";

const PassengerContainer = props => {

    return (
        <div className="passenger-container">
            {props.data?.map((elem, i) => <Passenger key={i} i={i} handlePassengerInput={props.handlePassengerInput} data={elem} />)}
            <PassengerButton newPassenger={props.handleNewPassenger}/>
        </div>
    );
}

export default PassengerContainer;