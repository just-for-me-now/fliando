import React from "react";

import Passenger from "./Passenger";

const PassengerContainer = () =>{

    const [passengers, setPassengers] = useState([])

    return <div className="passenger-container">
        <Passenger />
        
    </div>;
}

export default PassengerFormContainer;