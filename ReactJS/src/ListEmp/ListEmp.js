import React, { Component } from 'react';
import './ListEmp.css'

class ListEmp extends Component{
    state = {
        currDept : "ALL",
    }
    
    selectHandler = event =>{
        console.log("selectHAndler value: "+ event.target.value);
        this.setState({
            currDept: event.target.value
        });
    }

    render(){
        console.log("Employees",this.props.employees);
        return (
        <div>
            <h1>List of Employees</h1>
            <select id="choice" onChange={this.selectHandler}>
            <option value="ALL">ALL</option>
            {
                this.props.depts && this.props.depts.map((dept, i)=>{
                            return(<option value={dept.name}>{dept.name}</option>);
                })
            } 
            </select>
            <br/><br/>
            <table>
                <tr>
                    <th>Name</th>
                    <th>Age</th>
                    <th>Designation</th>
                    <th>Department</th>
                    <th>Location</th>
                </tr>
            
            {
                this.props.employees && this.props.employees.map((employee, i)=>{
                    console.log('currDept'+this.state.currDept);
                    if(this.state.currDept=="ALL" || employee.department==this.state.currDept)
                    return(
                    <tr key = {employee.name}> 
                        <td>{employee.name+" "+employee.lname}</td>
                        <td>{employee.age}</td>
                        <td>{employee.designation}</td>
                        <td>{employee.department}</td>
                        <td>{employee.location}</td>
                    </tr>
                );
            })
        }
            </table>
        </div>
        );
    }
}

export default ListEmp;