import { useState } from 'react';
import { BrowserRouter } from 'react-router-dom';import {
  BrowserRouter as Router,
  Routes,
  Route,
  Link
} from "react-router-dom";

import './App.css';
import Header from './components/Header/Header.js';
import SelectFlight from './components/SelectFlight/SelectFlight';
import FormSearch from './components/Form/FormSearch';

function App() {



  return (
    <>
     <div className="App">
    <Header/>
    <h2 className="titleh2">Where are you flying to?</h2>
    <FormSearch/>
    </div>
    </>
   
  );
}

export default App;
