import React, { Component } from 'react';
import EmployeeComponent from '../Employee/EmployeeComponent';

class AddEmp extends Component{
    
    data = {};
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
    /*
    add = e =>{
        e.preventDefault();
        //console.log("data",this.data);
        this.props.onEmpAdded(this.data);
        this.setState({
            show : false
        });
        this.data = {};
        alert("EMPLOYEE ADDED SUCCESSFULLY");
    }*/

    add = e =>{
        e.preventDefault();
        var name=document.getElementById('name').value.length;
        var age=document.getElementById('age').value;
        var age1=parseInt(age);
        console.log(age, age1, name);
        if(age1>18 && name<20){
            this.setState({show:false});
            this.props.onEmpAdded(this.data);
        }
        else{
        document.getElementById('error').innerHTML="error";
        }
    }
    
    handleChange = event =>{
        console.log(event.target.value);
        this.data[event.target.id] = event.target.value;
    }


    render(){
        return (
            <div>
                <button onClick={this.onClick}>NEW EMPLOYEE</button>
                {this.state.show && (
                <div>
                    <form>
                        <label>NAME </label><input type="text" id="name" onChange={this.handleChange} /><br />
                        <label>LAST </label><input type="text" id="lname" onChange={this.handleChange} /><br />
                        <label>AGE </label><input type="number" id="age" min="10" max="99" onChange={this.handleChange} /><br />
                        <label>DEPARTMENT </label><select id="department" onChange={this.handleChange}>
                            {
                            this.props.depts && this.props.depts.map((dept, i)=>{
                            return(<option value={dept.name}>{dept.name}</option>);
                        })} 
                            
                        </select><br/>
                        <label>DESIGNATION </label><input type="text" id="designation" onChange={this.handleChange} /><br />
                        <label>LOCATION </label><input type="text" id="location" onChange={this.handleChange} /><br />
                        <button onClick={this.add}>ADD</button>&ensp;
                        <button onClick={this.onCancel}>CANCEL</button>
                        <span id="error"></span>
                    </form>
                </div>
                    )}
            </div>
        );
    }
}

export default AddEmp;