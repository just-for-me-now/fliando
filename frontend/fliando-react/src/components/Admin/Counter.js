import React from "react";

const Counter = (props) =>{

    return (
        <div className="eachBlock">
            <div className="nameProp">{props.name}</div>
            <div className="counterProp">views : {props.counter}</div>
        </div>
    );
}

export default Counter;