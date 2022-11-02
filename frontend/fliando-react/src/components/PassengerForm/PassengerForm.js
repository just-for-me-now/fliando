import React, { useState } from "react";

const PassengerForm = (props) =>{
    const [enteredName, setEnteredName] = useState('');
    const [enteredSurame, setEnteredSurname] = useState('');
    const [enteredNif, setEnteredNif] = useState('');
    const [enteredAge, setEnteredAge] = useState('');

    const PassengerHandler = (props) => {
        setEnteredName('');
        setEnteredSurname('');
        setEnteredNif('');
        setEnteredAge('');
    }

    const nameChangeHandler = (event) => {
        setEnteredName(event.target.value);
    }

    const surnameChangeHandler = (event) => {
        setEnteredSurname(event.target.value);
    }

    const nifChangeHandler = (event) => {
        setEnteredNif(event.target.value);
    }

    const ageChangeHandler = (event) => {
        setEnteredAge(event.target.value);
    }


    return(
        
        <form onSubmit={PassengerHandler}>
            <label htmlFor="name">Name</label>
            <input id="name" type="text" value onChange={nameChangeHandler} />
            <label htmlFor="surname">Surname</label>
            <input id="surname" type="text" value onChange={surnameChangeHandler} />
            <label htmlFor="nif">NIF/Passport</label>
            <input type="text" value onChange={nifChangeHandler} />
            <label for="age">Age</label>
            <select onChange={ageChangeHandler}>
                <option value="">{"<"} 2</option>
                <option value=""> 2 {"<>"} 9</option>
                <option value="">{">"} 9</option>
            </select>
        </form>
    )
}

export default PassengerForm;