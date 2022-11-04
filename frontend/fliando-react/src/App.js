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
import axios from "axios";

function App() {

	const [searchData, setSearchData] = useState(null);
    const [flightData, setFlightData] = useState(null);
    const [passengerData, setPassengerData] = useState([]);
    const [admin, setAdmin] = useState(0);

    const search = (origin, originName, destination, destinationName, date) => {
        setSearchData({ origin, originName, destination, destinationName, date });
    }

    const handleSaveFlightData = data => {
        setFlightData(data);
    }

    const handlePassengerInput = (i, data) => {
        
        setPassengerData(prev => {
            let ans = [...prev];
            ans[i] = {
                ...ans[i],
                ...data,
            };
            return ans;
        });
    }

    const handleNewPassenger = () => {
        setPassengerData(prev => [
            ...prev,
            {
                name: "",
                surname: "",
                nationality: "",
                id: "",
                age: 2,
            }
        ]);
    }

    const sendBooking = () => {
        let body= {
            flightId: flightData,
            passengers: passengerData,
            luggage: 0,
            roundTrip: false,
            price: 0,
        };

        let toddlers = 0;
        let children = 0;
        let adults = 1;
        let luggage = 0;
        let roundTrip = false;

        let priceAddress = `http://localhost:8082/price?flightId=${body.flightId}&toddlers=${toddlers}&children=${children}&adults=${adults}&luggage=${luggage}&roundTrip=${roundTrip}`
        axios.get(priceAddress).then(response => {body.price = response.data; console.log(body); return body.price;}).then(
        axios.post(
            "http://localhost:8086/book",body, {
                headers: {
                    "Content-Type": "application/json",
                }
            }
        ).then(
            () => setAdmin(3),
            () => setAdmin(4)
        ));
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
    if(admin === 3) return <div><h1>Congratulations on finishing this app!</h1></div>
    if(admin === 4) return <div><h1>Congratulations on finishing this app with a wrong request!</h1></div>

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
                            handleSaveFlightData={handleSaveFlightData} /> 
                        : <div />
            }
            { flightData ?  <PassengerContainer handlePassengerInput={handlePassengerInput} handleNewPassenger={handleNewPassenger} data={passengerData} /> : <div /> }
            { passengerData.length > 0 ? <Button className="bookButton" onClick={sendBooking} >BOOK</Button> : <div /> }

		</div>
	);
}

export default App;
