import "./App.css";
import Header from "./components/Header/Header.js";
import FormSearch from "./components/Form/FormSearch";
import FlightContainer from "./components/Flights/FlightContainer";
import PassengerForm from "./components/PassengerForm/PassengerForm";
import { useState } from "react";

function App() {

	const [searchData, setSearchData] = useState(null);

    const search = (origin, originName, destination, destinationName, date) => {
        setSearchData({ origin, originName, destination, destinationName, date });
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
                            date={searchData.date} /> 
                        : <div />
            }
			<PassengerForm />
		</div>
	);
}

export default App;
