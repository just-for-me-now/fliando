

const AdminButton = props =>{
    return (
        <button className="adminButton" onClick={props.action}>{props.text}</button>

    )
}

export default AdminButton;