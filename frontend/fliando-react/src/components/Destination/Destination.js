import React, { useState } from "react";

import Card from "../UI/Card/Card.js";

const Destination = (props) =>{

    return(
        <Card>
            <label for="destination">Destination</label>
            <select name="destination" id="destination">
                <option value></option>
            </select>
        </Card>
    )
}

export default Destination;