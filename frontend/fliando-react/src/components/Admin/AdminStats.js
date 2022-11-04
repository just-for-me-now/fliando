import React from "react";
import Counter from "./Counter";
import useFetch from "../UseFetch/UseFetch";

const AdminStats = () =>{

    const address = `http://localhost:8085/counts`;
    console.log(address)
    const { data } = useFetch(address);

    return (
        <div>
            {data?.map(elem=><Counter name={elem.name} counter={elem.counter}></Counter>)}
        </div>
        
    )
}

export default AdminStats;