import React, {useEffect,useState} from 'react';
import axios from 'axios';

const url = "";

function useFetch(url){

    const [data, setData] = useState([]);

    const [loading, setLoading] = useState([]);

    const [error, setError] = useState([]);

    useEffect(()=>{

        setLoading(true);
        axios
            .get(url)
            .then((response)=>{
                setData(response.data)
            })
            .catch((err)=>{
                setError(err);
            })
            .finally(()=>{
                setLoading(false)
            })
    },[url]);

    const refetch = () =>{
        setLoading(true);
        axios
            .get(url)
            .then((response)=>{
                setData(response.data);
            })
            .catch((err)=>{
                setError(err);
            })
            .finally(()=>{
                setLoading(false)
            })
    }
    return {data, loading, error, refetch}


}
export default useFetch