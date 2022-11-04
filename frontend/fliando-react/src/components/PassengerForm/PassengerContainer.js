import React, {useState} from "react";

import Passenger from "./Passenger";
import PassengerButton from "./PassengerButton";

const PassengerContainer = () =>{

    const [passengers, setPassengers] = useState([{
        name:"",
        surname:"",
        nationality:"",
        id:"",
        age:0
    }])

    const handleNewPassenger = () =>{
        setPassengers((previousState)=>[
            ...previousState,
            {
                name:"",
                surname:"",
                nationality:"",
                id:"",
                age:0
            }
        ])
    }

    return <div className="passenger-container">
        {passengers?console.log(passengers):"nada"}
        {passengers?.map((elem , i)=> {return <Passenger key={i} />})}
        <PassengerButton newPassenger={handleNewPassenger}/>
    </div>;
}

export default PassengerContainer;