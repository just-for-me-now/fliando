import React from "react";

const AdminLogin = props =>{

    const handleSubmit = (e) =>{
        e.preventDefault();
        props.action();
    }


    return (
        <form className="loginForm" onSubmit={handleSubmit}>
            <div>
            <label>Username : </label>
            <input type="text"></input>
            </div>
            <label>Password : </label>
            <input type="password"></input>
            <button className="button submitButton" type="submit">Submit</button>
        </form>
    )
}

export default AdminLogin;