import { useState } from "react";
import React from "react";
import Card from "../UI/Card/Card";
import Button from "../UI/Button/Button";

const Form = () => {
 

    const [search, setSearch] = useState({});

    const handleChange = (e) =>{
      const name = e.target.name;
      const value = e.target.value;
      setSearch( {...search,[name]:value})
    }
    const submitSearch = (e) =>{
      e.preventDefault();
      console.log(search)
    }
    return (
  <Form className="flightBox" onSubmit={submitSearch}>
    <Card>
      <h2 className="titleh2">Where are you flying to?</h2>
      <label htmlFor="origin">Origin</label>
      <select name="origin" id="origin" onChange={handleChange}>
        
          <option value></option>
        
      </select>
    </Card>

    <Card>
      <label htmlFor="destination">Destination</label>
      <select name="destination" id="destination" onChange={handleChange}>
        
          <option value> </option>
        
      </select>
    </Card>

    <Card>
      <label htmlFor="date">Date</label>
      <select name="date" id="date" onChange={handleChange}>
        
          <option value> </option>
        
      </select>
    </Card>
    <Button type="submit"> Search </Button>
  </Form>
  )
};

export default Form;
