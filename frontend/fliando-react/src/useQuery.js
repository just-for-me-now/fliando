import React, { useEffect } from "react";
import axios from "axios";

function useQuery(){
    const[data, setData] = useState(null);
    const[loading, setLoading] = useState(false);
    const[error, setError] = useState(null);

    useEffect(() => {
        setLoading(true);
        axios
            .post(url)
            .then((response) =>{
                setData(response.data);
            }).catch((err) =>{
                setError(err);
            }).finally(() => {
                setLoading(false);
        });

    },[url]);

    return {data, loading, error}
}

export default useQuery