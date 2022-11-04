import axios from "axios";
import React, {useState} from "react";
import useFetch from "../UseFetch/UseFetch";

const AdminLogin = props =>{

    const address = "http://localhost:8087/users";

    const [user, setUser] = useState("");
    const [password, setPassword] = useState("");
    
    const handleSubmit = (e) =>{
        e.preventDefault();
        let body = {name: user, password}
        console.log(body)
        axios.post(address, body, {headers:{"Content-Type":"application/json"}}).then(response => {
            response.status == 200 ? props.action() : console.log("fail");
        }, () => alert("Wrong username or password value"))
    }
    const handleUser = (e) =>{
        setUser(e.target.value);
    }
    const handlePassword = (e) =>{
        setPassword(e.target.value);
    }

    return (
        <form className="loginForm" onSubmit={handleSubmit}>
            <div>
            <label>Username : </label>
            <input type="text" value={user} onChange={handleUser}></input>
            </div>
            <label>Password : </label>
            <input  type="password" value={password} onChange={handlePassword}></input>
            <button className="button submitButton" type="submit">Submit</button>
        </form>
    )
}

export default AdminLogin;