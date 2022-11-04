import React from "react";
import Counter from "./Counter";
import useFetch from "../UseFetch/UseFetch";

const AdminStats = () =>{

    const address = `http://localhost:8085/accounts`;
    console.log(address)
    const { data } = useFetch(address);

    return (
        <div>
            {data?.map(elem=><Counter name={data.name} counter={data.counter}></Counter>)}
        </div>
        
    )
}

export default AdminStats;