import React, {useState} from "react";

import Passenger from "./Passenger";
import PassengerButton from "./PassengerButton";

const PassengerContainer = props =>{

    const [passengers, setPassengers] = useState([{
        name:"",
        surname:"",
        nationality:"",
        id:"",
        age:0
    }])

    const sendPassengersUp = () => {
        setPassengers(prev => {
            props.receivePassengers(prev);
            return props;
        })
    }

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

        sendPassengersUp();
    }

    const handlePassengerDataChange = (id, newData) => {
        setPassengers(
            previousState => {
                let newState = [...previousState];
                for(let i = 0; i < newState.length; i++) {
                    if(newState[i].id == id) {
                        newState[i] = newData;
                    }
                }
                return newState;
            }
        );

        console.log(passengers);
        sendPassengersUp();
    }

    return <div className="passenger-container">
        {passengers?.map(elem => <Passenger key={elem.id} update={handlePassengerDataChange} state={elem} />)}
        <PassengerButton newPassenger={handleNewPassenger}/>
    </div>;
}

export default PassengerContainer;