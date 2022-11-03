import { useState } from "react";
import React from "react";
import Card from "../UI/Card/Card";
import Button from "../UI/Button/Button";
import useFetch from "../UseFetch/UseFetch";

const FormSearch = props => {
  //states
  
  const { data } = useFetch(`http://localhost:8084/origins`)
  const [origin, setOrigin] = useState(null);
  const [originName, setOriginName] = useState(null);
  const [destinationList, setDestinationList] = useState(null);
  const [destination, setDestination] = useState(null);
  const [destinationName, setDestinationName] = useState(null);
  const [date, setDate] = useState(null);
  
  //handlers
  const handleOrigin = event => {
    setOrigin(event.target.value);
    const o = data.find(elem => elem.id == event.target.value);
    setOriginName(o.name)
    setDestinationList(o.destinations);
  }

  const handleDestination = (e) => {
    setDestination(e.target.value);
    const d = data.find(elem => elem.id == origin).destinations.find(elem => elem.id == e.target.value)
    console.log(d.id)
    setDestinationName(d.name)
  };

  const handleDate = (e) => {
    setDate(e.target.value);
  };

  const submitSearch = event => {
    event.preventDefault();
    if(origin == null || destination == null || date == null) return;
    props.search(origin, originName, destination, destinationName, date);
  };
  
  return (
    <form className="flightBox" onSubmit={submitSearch}>
      <Card>
        <label htmlFor="origin">Origin</label>
        <select name="origin" id="origin" onChange={handleOrigin}>
        <option>---------</option>
        {data?.map(elem => <option key={elem.id} value={elem.id}>{elem.name}</option>)}
        </select>
      </Card>

      <Card>
        <label htmlFor="destination">Destination</label>
        <select name="destination" id="destination" onChange={handleDestination}>
        <option>---------</option>
        { destinationList?.map(elem => <option key={elem.id} value={elem.id}>{elem.name}</option>) }
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
