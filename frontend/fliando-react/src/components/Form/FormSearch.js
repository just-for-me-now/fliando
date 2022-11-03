import { useState, useEffect  } from "react";
import React from "react";
import Card from "../UI/Card/Card";
import Button from "../UI/Button/Button";
import useFetch from "../UseFetch/UseFetch";

const FormSearch = (props) => {

  const { data, loading, error, refetch } = useFetch(
    `http://localhost:8084/origins`
  )
  //states
  const [origin, setOrigin] = useState(null);
  const [destination, setDestination] = useState(null);
  const [date, setDate] = useState(null);
  const [destinationList, setDestinationList] = useState(null);
  //handlers
  const handleOrigin = (e) =>{
    setOrigin(e.target.value)
    console.log(data)
    setDestinationList(data.find(elem => elem.id ==e.target.value).destinations);
  }
  //const [search, setSearch] = useState({});

  const handleDestination = (e) => {
    setDestination(e.target.value)

  };

  const handleDate = (e)=>{
    setDate(e.target.value)
  }  
  const submitSearch = (e) => {
    e.preventDefault();
    console.log(origin);
    console.log(destination);
    console.log(date);

    props.submitSearch(origin, destination, date)
  };

  return (
    <form className="flightBox mainCSS" onSubmit={submitSearch}>
      <Card>
        <label htmlFor="origin">Origin</label>
        <select name="origin" id="origin" onChange={handleOrigin}>
        <option>---------</option>
        {data?.map(elem=> <option key={elem.id} value={elem.id}>{elem.name}</option>)}
        </select>
      </Card>

      <Card>
        <label htmlFor="destination">Destination</label>
        <select name="destination" id="destination" onChange={handleDestination}>
        <option>---------</option>
        {destinationList ? console.log(destinationList):""}
        { destinationList?.map(elem => <option key={elem.id} value={elem.id}>{elem.name}</option>)}
        </select>
      </Card>

      <Card>
        <label htmlFor="date">Date</label>
        <input type="date" name="date" id="date" onChange={handleDate}></input>
      </Card>
      <Button type="submit"> Search </Button>
    </form>
  );
};

export default FormSearch;
