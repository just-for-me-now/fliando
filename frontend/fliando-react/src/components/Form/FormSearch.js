import { useState, useEffect  } from "react";
import React from "react";
import Card from "../UI/Card/Card";
import Button from "../UI/Button/Button";
import useFetch from "../UseFetch/UseFetch";

const FormSearch = () => {
  //states
  const [origin, setOrigin] = useState(null);
  const [destinations, setDestinations] = useState(null)
  const [dateValue, setDateValue] = useState(null);
  
  //handlers
  const handleOrigin = (e) =>{
    setOrigin(e.target.value)
    console.log("target value e -> "+e.target.value)
    console.log("target value origin -> "+origin)
  }
  //const [search, setSearch] = useState({});

  const handleChange = (e) => {
    console.log("handle change ->"+e)

  };
  const submitSearch = (e) => {
    // e.preventDefault();
    // console.log(search);
  };

  useEffect(() => {
    
  }, [origin]);

  /*fetch */
  const { data, loading, error, refetch } = useFetch(
    "http://localhost:8084/origins"
  );
  console.log(data)
  if (loading) {
    //return <p>LOADING...</p>;
  }
  if (error) {
    //return <p className="errorMessage"></p>;
  }
  /*fetch */
  console.log('Valor de origin -> '+origin)
  return (
    <form className="flightBox" onSubmit={submitSearch}>
      <Card>
        <label htmlFor="origin">Origin</label>
        <select name="origin" id="origin" onChange={handleOrigin}>
        {data?.map(elem => <option value={elem}>{elem.name}</option>)}
        </select>
      </Card>

      <Card>
        <label htmlFor="destination">Destination</label>
        <select name="destination" id="destination" onChange={handleChange}>
        { origin?.destinations?.map((elem, index) => { return (<option key={index}>{elem.name}</option>);})}
        </select>
      </Card>

      <Card>
        <label htmlFor="date">Date</label>
        <input type="date" name="date" id="date" onChange={handleChange}></input>
      </Card>
      <Button type="submit"> Search </Button>
    </form>
  );
};

export default FormSearch;
