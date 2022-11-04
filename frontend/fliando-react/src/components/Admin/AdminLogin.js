import React from "react";

const AdminLogin = props =>{

    const handleSubmit = (e) =>{
        e.preventDefault();
        props.action();
    }


    return (
        <form onSubmit={handleSubmit}>
            <div>
            <label>Username</label>
            <input type="text"></input>
            </div>
            <label>Username</label>
            <input type="password"></input>
            <button className="button" type="submit">Submit</button>
        </form>
    )
}

export default AdminLogin;