import "./App.css";
import { useState } from "react";
import Header from "./components/Header/Header.js";
import FormSearch from "./components/Form/FormSearch";
import FlightContainer from "./components/Flights/FlightContainer";

import PassengerContainer from "./components/PassengerForm/PassengerContainer.js";
import Button from "./components/UI/Button/Button";
import AdminLogin from "./components/Admin/AdminLogin";
import AdminStats from "./components/Admin/AdminStats";
import AdminButton from "./components/Admin/AdminButton";

function App() {

	const [searchData, setSearchData] = useState(null);
    const [flightData, setFlightData] = useState(null);
    const [passengerData, setPassengerData] = useState(null);
    const [admin, setAdmin] = useState(0)

    const search = (origin, originName, destination, destinationName, date) => {
        setSearchData({ origin, originName, destination, destinationName, date });
    }

    const handleSaveFlightData = data => {
        setFlightData(data);
    }

    const handlePassengers = data => {
        setPassengerData(data);
    }
    
    const sendToLogin = () =>{
        setAdmin(1);
    }
    const sendToMain = () =>{
        setAdmin(0);
    }
    const sendToStats = () =>{
        setAdmin(2);
    }

    if(admin === 1) return (
        <div className="App">
            <AdminLogin  action={sendToStats}/>
            <AdminButton action={sendToMain} text={"Main"}/>
        </div>
    )
    if (admin === 2) return(
        <div>
            <AdminStats/>
            <AdminButton action={sendToMain} text={"Main"}/>
        </div>
    )

	return (
		<div className="App">
			<Header />
			<h2 className="titleh2">Where are you flying to?</h2>
            <AdminButton action={sendToLogin} text={"Login"}/>
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
            {/* flightData ?  <PassengerContainer /><Button className="bookButton">BOOK</Button> : <div />*/}
			<PassengerContainer receivePassengers={handlePassengers} />
            <Button className="bookButton">BOOK</Button>

		</div>
	);
}

export default App;
