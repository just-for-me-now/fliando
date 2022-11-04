import React, { useState } from "react";
import Card from "../UI/Card/Card";
import './Passenger.css'



const Passenger = (props) => {
    
    const nameChangeHandler = (event) => {
        props.handlePassengerInput(props.i, {name: event.target.value});
    }
    
    const surnameChangeHandler = (event) => {
        props.handlePassengerInput(props.i, {surname: event.target.value});
    }
    
    const nationalityChangeHandler = (event) => {
        props.handlePassengerInput(props.i, {nationality: event.target.value});
    }
    
    const idChangeHandler = (event) => {
        props.handlePassengerInput(props.i, {id: event.target.value});
    }
    
    const ageChangeHandler = (event) => {
        props.handlePassengerInput(props.i, {age: event.target.value});
    }

    return (
            <Card className="flightBox passenger">
                <fieldset>
                <legend>PERSONAL DATA</legend>
                <label htmlFor="name">Name</label>
                <input id="name" type="text" onChange={nameChangeHandler} value={props.data.name} />
                <label htmlFor="surname">Surname</label>
                <input id="surname" type="text" onChange={surnameChangeHandler} value={props.data.surname} />
                <label htmlFor="nationality">Nationality</label>
                <input id="nationality" type="text" onChange={nationalityChangeHandler} value={props.data.nationality} />
                <label htmlFor="nif">NIF/Passport</label>
                <input type="text" onChange={idChangeHandler} value={props.data.id} />
                <label htmlFor="age">Age</label>
                <select onChange={ageChangeHandler} value={props.data.age}>
                    <option value="0">{"<"} 2</option>
                    <option value="1"> 2 {"<>"} 9</option>
                    <option value="2">{">"} 9</option>
                </select>
                </fieldset>
            </Card>   
    
    )
}

export default Passenger;