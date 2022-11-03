import { useState } from "react";
import React from "react";
import Card from "../UI/Card/Card";
import Button from "../UI/Button/Button";
import useFetch from "../UseFetch/UseFetch";

const FormSearch = () => {
  //const [search, setSearch] = useState({});

  const handleChange = (e) => {
    // const name = e.target.name;
    // const value = e.target.value;
    // setSearch({ ...search, [name]: value });
  };
  const submitSearch = (e) => {
    // e.preventDefault();
    // console.log(search);
  };

  /*fetch */
  const { data, loading, error, refetch } = useFetch(
    "http://localhost:8084/origins"
  );
  console.log(data)
  if (loading) {
    return <h3>LOADING...</h3>;
  }
  if (error) {
    return <h3>NO SUCH INFORMATION</h3>
  }
  /*fetch */

  return (
    <form className="flightBox" onSubmit={submitSearch}>
      <Card>
        <label htmlFor="origin">Origin</label>
        <select name="origin" id="origin" onChange={handleChange}>
        {data?.map(elem => <option>{elem.name}</option>)}
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
        <input type="date" name="date" id="date" onChange={handleChange}></input>
      </Card>
      <Button type="submit"> Search </Button>
    </form>
  );
};

export default FormSearch;
