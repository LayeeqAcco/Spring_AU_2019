import React, {Component} from 'react';

class AddDept extends Component{

    data = {};  //store temp data
    state = {
        show : false
    }
    
    onClick = () => {
        this.setState({
            show : true
        });
    }
    
    onCancel = e => {
        e.preventDefault();
        this.setState({
            show : false
        });
    }
    
    add = e =>{
        e.preventDefault();
        console.log("data",this.data);
        this.props.onDeptAdded(this.data);
        this.setState({
            show : false
        });
        alert('ADDED DEPARTMENT SUCCESSFULLY');
    }

    handleChange = event =>{
        console.log(event.target.value);
        this.data[event.target.id] = event.target.value;
    }


    render(){
        return (
            <div>
                <button onClick={this.onClick}>NEW DEPT</button>
                {this.state.show && (
                <div>
                    <form>
                        <label>NAME </label><input type="text" id="name" onChange={this.handleChange} /><br />
                        <label>DESCRIPTION </label><input type="text" id="description" onChange={this.handleChange} /><br />
                        <button onClick={this.add}>ADD</button>&ensp;
                        <button onClick={this.onCancel}>CANCEL</button>
                    </form>
                </div>
                    )}
            </div>
        );
    }
}


export default AddDept;