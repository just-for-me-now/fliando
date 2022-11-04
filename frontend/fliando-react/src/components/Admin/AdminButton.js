import React from "react";

const AdminButton = props =>{
    return (
        <button className="adminButton button" onClick={props.action}>{props.text}</button>

    )
}

export default AdminButton;