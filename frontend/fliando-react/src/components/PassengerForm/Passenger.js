import React, { useState } from "react";
import Card from "../UI/Card/Card";
import './Passenger.css'



const Passenger = (props) => {

    const [enteredName, setEnteredName] = useState(props.state.name);
    const [enteredSurname, setEnteredSurname] = useState(props.state.surname);
    const [enteredNationality, setEnteredNationality] = useState(props.state.nationality);
    const [enteredNif, setEnteredId] = useState(props.state.id);
    const [enteredAge, setEnteredAge] = useState(props.state.age);
    
    const nameChangeHandler = (event) => {
        setEnteredName(event.target.value);
    }
    
    const surnameChangeHandler = (event) => {
        setEnteredSurname(event.target.value);
    }
    
    const nationalityChangeHandler = (event) => {
        setEnteredNationality(event.target.value)
    }
    
    const idChangeHandler = (event) => {
        setEnteredId(event.target.value);
    }
    
    const ageChangeHandler = (event) => {
        setEnteredAge(event.target.value);
    }

    return (
            <Card className="flightBox">
                <fieldset>
                <legend>PERSONAL DATA</legend>
                <label htmlFor="name">Name</label>
                <input id="name" type="text" onChange={nameChangeHandler} value={enteredName} />
                <label htmlFor="surname">Surname</label>
                <input id="surname" type="text" onChange={surnameChangeHandler} value={enteredSurname} />
                <label htmlFor="nationality">Nationality</label>
                <input id="nationality" type="text" onChange={nationalityChangeHandler} value={enteredNationality} />
                <label htmlFor="nif">NIF/Passport</label>
                <input type="text" onChange={idChangeHandler} value={enteredNif} />
                <label htmlFor="age">Age</label>
                <select onChange={ageChangeHandler} value={enteredAge}>
                    <option value="0">{"<"} 2</option>
                    <option value="1"> 2 {"<>"} 9</option>
                    <option value="2">{">"} 9</option>
                </select>
                </fieldset>
            </Card>   
    
    )
}

export default Passenger;