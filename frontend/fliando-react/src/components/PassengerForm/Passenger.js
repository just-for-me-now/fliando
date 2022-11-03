import React, { useState } from "react";



const Passenger = () => {

    const [enteredName, setEnteredName] = useState('');
    const [enteredSurname, setEnteredSurname] = useState('');
    const [enteredNationality, setEnteredNationality] = useState('');
    const [enteredNif, setEnteredNif] = useState('');
    const [enteredAge, setEnteredAge] = useState('');

    const PassengerHandler = (event) => {
        event.preventDefault();
    
        if(enteredName.trim().length === 0 || 
        enteredSurname.trim().length === 0 || 
        enteredNationality.trim().length === 0||
        enteredNif.trim().length === 0 ||
        enteredAge.trim().length === 0)
        {
            return;
        }
        if(+enteredAge < 0){
            return;
        }
    
        
        setEnteredName(''); 
        setEnteredSurname('');
        setEnteredNationality('');
        setEnteredNif('');
        setEnteredAge('');
    }
    
    const nameChangeHandler = (event) => {
        setEnteredName(event.target.value);
    }
    
    const surnameChangeHandler = (event) => {
        setEnteredSurname(event.target.value);
    }
    
    const nationalityChangeHandler = (event) => {
        setEnteredNationality(event.target.value)
    }
    
    const nifChangeHandler = (event) => {
        setEnteredNif(event.target.value);
    }
    
    const ageChangeHandler = (event) => {
        setEnteredAge(event.target.value);
    }

    return (
    <div><label htmlFor="name">Name</label>
    <input id="name" type="text" onChange={nameChangeHandler} />
    <label htmlFor="surname">Surname</label>
    <input id="surname" type="text" onChange={surnameChangeHandler} />
    <label htmlFor="nationality">Nationality</label>
    <input id="nationality" type="text" onChange={nationalityChangeHandler} />
    <label htmlFor="nif">NIF/Passport</label>
    <input type="text" onChange={nifChangeHandler} />
    <label htmlFor="age">Age</label>
    <select onChange={ageChangeHandler}>
        <option value="">{"<"} 2</option>
        <option value=""> 2 {"<>"} 9</option>
        <option value="">{">"} 9</option>
    </select></div>
    )
}

export default Passenger;