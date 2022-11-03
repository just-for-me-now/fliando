const FlightFilter = props => {

    const handleScales = event => {
        if(event.target.value)
            props.filterBy("scales", false);
    }

    return (
        <div>
            <label>Filter out flights with scales</label>
            <input type="checkbox" onChange={handleScales}/>
        </div>
    );
}

export default FlightFilter;