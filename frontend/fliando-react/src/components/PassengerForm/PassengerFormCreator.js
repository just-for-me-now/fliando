import React, { useState } from "react";

import PassengerForm from "./PassengerForm";
import Button from "../../UI//Button/Button.js";


const PassengerFormCreator = (props) => {
    const [forms, setForms] = useState([<PassengerForm />])

    const createForm = () => {
        setForms([...forms,<PassengerForm />])
    }

    return(
        <Button onClick={createForm} text="Add Passenger" />
        
    )
}


export default PassengerFormCreator;