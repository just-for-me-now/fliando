import "./App.css";
import Header from "./components/Header/Header.js";
import FormSearch from "./components/Form/FormSearch";
import FlightContainer from "./components/Flights/FlightContainer";
import Passenger from "./components/PassengerForm/Passenger.js";
function App() {
	return (
		<div className="App">
			<Header />
			<h2 className="titleh2">Where are you flying to?</h2>
			<FormSearch />
			<FlightContainer />
			<Passenger />
		</div>
	);
}

export default App;
