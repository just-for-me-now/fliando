import "./App.css";
import Header from "./components/Header/Header.js";
import FormSearch from "./components/Form/FormSearch";
import FlightContainer from "./components/Flights/FlightContainer";
import Passenger from "./components/PassengerForm/Passenger.js";
import Button from "./components/UI/Button/Button";

import { useState } from "react";


function App() {

	const [searchData, setSearchData] = useState(null);
    const [flightData, setFlightData] = useState(null);

    const search = (origin, originName, destination, destinationName, date) => {
        setSearchData({ origin, originName, destination, destinationName, date });
    }

    const handleSaveFlightData = data => {
        setFlightData(data);
    }

	return (
		<div className="App">
			<Header />
			<h2 className="titleh2">Where are you flying to?</h2>

			
			<FormSearch search={search} />
			{searchData ? <FlightContainer 
                            origin={searchData.origin} 
                            originName={searchData.originName} 
                            destination={searchData.destination} 
                            destinationName={searchData.destinationName} 
                            date={searchData.date}
                            save={handleSaveFlightData} /> 
                        : <div />
            }
            {/* flightData ?  <Passenger /><Button className="bookButton">BOOK</Button> : <div />*/}
			<Passenger />
            <Button className="bookButton">BOOK</Button>

		</div>
	);
}

export default App;
