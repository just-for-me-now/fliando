import './App.css';
import Header from './components/Header/Header.js';
import FormSearch from './components/Form/FormSearch';
import FlightContainer from './components/Flights/FlightContainer';
import PassengerForm from './components/PassengerForm/PassengerForm';
import useFetch from './components/UseFetch/UseFetch';
import { useEffect } from 'react';
function App() {
  //http://localhost:8084/origins

  return (
    <div className="App">
      <Header />
      <h2 className="titleh2">Where are you flying to?</h2>
      <FormSearch />
      <FlightContainer />
      <PassengerForm />
    </div>
  );
}

export default App;