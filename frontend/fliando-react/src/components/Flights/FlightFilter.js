const FlightFilter = (props) => {
	const handleScales = (event) => {
		props.filterBy("scales", event.target.checked);
	};

	const handleAirline = (event) => {
		props.filterBy("airline", event.target.value);
	};

	const handleLuggage = (event) => {
		props.filterBy("luggage", event.target.checked);
	};

	return (
		<div className="flightBox flight-filter">
			<div>
				<label>Scales</label>
				<input type="checkbox" onChange={handleScales} />
			</div>
            <div>
	    		<label>Airline</label>
    			<input type="text" onChange={handleAirline} />
            </div>
            <div>
	    		<label>Luggage</label>
    			<input type="checkbox" onChange={handleLuggage} />
            </div>

		</div>
	);
};

export default FlightFilter;
