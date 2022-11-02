import React, { useState } from "react";

import Card from "../UI/Card/Card.js";

const Date = (props) =>{

    return(
        <Card>
            <label for="date">Origin</label>
            <select name="date" id="date">
                <option value></option>
            </select>
        </Card>
    )
}

export default Date;