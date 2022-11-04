import React from "react";

const Counter = (props) =>{

    return (
        <div>
            <div>name : {props.name}</div>
            <div>counter : {props.counter}</div>
        </div>
    );
}

export default Counter;