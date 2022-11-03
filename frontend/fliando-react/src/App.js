import "./App.css";
import Header from "./components/Header/Header.js";
import FormSearch from "./components/Form/FormSearch";
import FlightContainer from "./components/Flights/FlightContainer";
import PassengerForm from "./components/PassengerForm/PassengerForm";
import { useState } from "react";
import useFetchDelayed from "./components/UseFetch/UseFetchDelayed";

function App() {

	const [appState, setAppState] = useState(0);
	const { data, loading, error, refetch } = useFetchDelayed("http://localhost:8084/origins/1/destinations/1/dates/2022-11-11");


	const origin = "Sevilla";
	const destination = "Lisbon";
	let _flights = [
        {
            "id":"1",
            "origin": "Sevilla",
            "destination": "Lisboa",
            "time":{"date":"2022-11-11","time":"11:45"},
            "airline": "Lufthansa",
            "scales": true,
            "pricePerAdult": 50,
        },
        {
            "id":"2",
            "origin": "Valencia",
            "destination": "Chicago",
            "time":{"date":"2022-11-15","time":"13:00"},
            "airline": "Tam",
            "scales": false,
            "pricePerAdult": 50,
        },
        {
            "id":"3",
            "origin": "Sevilla",
            "destination": "Lisboa",
            "time":{"date":"2022-11-11","time":"11:45"},
            "airline": "Lufthansa",
            "scales": true,
            "pricePerAdult": 50,
        },
    ]

	const click = event => {
		event.preventDefault()
		setAppState(1);
		refetch();
	}

	return (
		<div className="App">
			<Header />
			<h2 className="titleh2">Where are you flying to?</h2>
			<FormSearch />
			<button onClick={click}>click me</button>
			{loading ? <div>"Loading"</div> : ""}
			<FlightContainer flights={data} origin={origin} destination={destination} />
			<PassengerForm />
		</div>
	);
}

export default App;
