import React, { useState } from "react";

import Card from "../UI/Card/Card.js";

const Origin = (props) =>{
    

    return(
        <Card>
            <label for="origin">Origin</label>
            <select name="origin" id="origin">
                <>
                <option value></option>
                </>
                
            </select>
        </Card>
    )
}

export default Origin;