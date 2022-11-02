import React, { useState } from "react";

import Card from "../UI/Card/Card.js";
import Button from "../UI//Button/Button.js";
import Origin from "../Origin/Origin.js";
import Destination from "../Destination/Destination.js";
import Date from "../Date/Date.js";

const SelectFlight = (props) => {
  const [origin, setOrigin] = useState("");
  const [destination, setDestination] = useState("");
  const [date, setDate] = useState("");

  const originHandler = (event) => {};

  const destinationHandler = (event) => {};

  const dateHandler = (event) => {};

  return (
    <>
      <h2 className="titleh2">Where are you flying?</h2>
      <Card className="flightBox">
        <Origin />
        <Destination />
        <Date />
        <Button type="submit" /> Search <Button />
      </Card>
    </>
  );
};

export default SelectFlight;
