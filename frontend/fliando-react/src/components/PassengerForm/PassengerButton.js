import React from "react";

const PassengerButton = props => {

    const handleNewPassenger= () =>{
        props.newPassenger();
    }

    return (
        <button onClick={handleNewPassenger} className="button">New Passenger</button>
    );
}

export default PassengerButton;