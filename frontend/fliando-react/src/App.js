import { useState } from 'react';
import { BrowserRouter } from 'react-router-dom';import {
  BrowserRouter as Router,
  Switch,
  Route,
  Link
} from "react-router-dom";

import './App.css';
import Header from './components/Header/Header.js';
import SelectFlight from './components/SelectFlight/SelectFlight.js';

function App() {



  return (
    <>
     <div className="App">
      <Header />
      <SelectFlight />
    </div>
    
    </>
   
  );
}

export default App;
