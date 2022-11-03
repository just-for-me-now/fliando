import './App.css';
import Header from './components/Header/Header.js';
import FormSearch from './components/Form/FormSearch';
import FlightContainer from './components/Flights/FlightContainer';
import PassengerForm from './components/PassengerForm/PassengerForm';
import useFetch from './components/UseFetch/UseFetch';
function App() {
    //https://v2.jokeapi.dev/joke/Any
  //http://localhost:8084/origins
  const { data, loading, error, refetch } = useFetch(
    "http://localhost:8084/origins"
  );
  console.log(data)
  if (loading) {
    return <h3>LOADING...</h3>;
  }
  if (error) {
    return <h3>NO SUCH INFORMATION</h3>
  }

  return (
    <div className="App">
      <Header />
      <h2 className="titleh2">Where are you flying to?</h2>
      <FormSearch />
      <FlightContainer />
      <PassengerForm />
      <div>
        <h3>{data?.setup} : {data?.delivery}</h3>
        <h3></h3>
        <button onClick={refetch}>Refetch</button>
      </div>
    </div>
  );
}

export default App;
