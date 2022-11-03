import { useState, useEffect  } from "react";
import React from "react";
import Card from "../UI/Card/Card";
import Button from "../UI/Button/Button";
import useFetch from "../UseFetch/UseFetch";

const FormSearch = () => {
  //states
  const [origin, setOrigin] = useState({});
  const [destinations, setDestinations] = useState({})
  const [dateValue, setDateValue] = useState({});
  const [id, setId] = useState({});
  const myObj = {};
  //handlers
  const handleOrigin = (e) =>{
    setOrigin(e.target.value)
    console.log("target value origin -> "+origin)
  }
  //const [search, setSearch] = useState({});

  const handleChange = (e) => {
    // console.log("handle change ->"+e)

  };
  const submitSearch = (e) => {
    // e.preventDefault();
    // console.log(search);
  };

  useEffect(() => {
    
  }, [origin]);

  /*fetch */
  const { data, loading, error, refetch } = useFetch(
    `http://localhost:8084/origins`
  )
  // console.log(data)
  if (loading) {
    //return <p>LOADING...</p>;
  }
  if (error) {
    //return <p className="errorMessage"></p>;
  }
  /*fetch */
  // console.log('Valor de origin -> '+origin)
  return (
    <form className="flightBox mainCSS" onSubmit={submitSearch}>
      <Card>
        <label htmlFor="origin">Origin</label>
        <select name="origin" id="origin" onChange={handleOrigin}>
        {data?.map((elem, index) => <option key={index} value={elem}>{elem.name}</option>)}
        </select>
      </Card>

      <Card>
        <label htmlFor="destination">Destination</label>
        <select name="destination" id="destination" value={origin} onChange={handleChange}>
        <option>---------</option>
        { origin?.destinations?.map((elem) => <option key={elem.id} value={elem.name}>{elem.name}</option>)}
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
