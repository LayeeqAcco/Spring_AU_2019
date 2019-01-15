import React, { Component } from 'react';

import AddEmp from '../AddEmp/AddEmp';
import ListEmp from '../ListEmp/ListEmp';
import AddDept from '../Department/AddDept';
import ListDept from '../Department/ListDept';


class EmployeeComponent extends Component{
    state = {
        employees: [
            {
              name: "raviteja",
              lname: "V",
              age: 21,
              designation: "intern",
              department: "HR",
              location: "Mangalore, Karnataka,India, Asia, World, Earth"
            },
            {
              name: "Devraj",
              lname: "M",
              age: 21,
              designation: "intern",
              department: "HR",
              location: "Bangalore,Karnataka,India, Asia, World, Earth"
            },
            {
              name: "kumar",
              lname: "santanu",
              age: 26,
              designation: "intern",
              department: "IT",
              location: "Patna, Bihar,India, Asia, World, Earth"
            }
          ],
        depts: [
            {
                name: "HR",
                description: "handles human resources"
            },
            {
                name: "IT",
                description: "handles tech"
            }
        ]  
    }
    
    onEmpAdded = newEmpData =>{
        console.log("new data",newEmpData);
        let employees = [...this.state.employees];
        employees.push(newEmpData);
        this.setState({employees:employees});
    }

    onDeptAdded = newDeptData =>{
        console.log("new data",newDeptData);
        let depts = [...this.state.depts];
        depts.push(newDeptData);
        this.setState({depts:depts});
    }

    render() {
        return(
        <React.Fragment>
            <AddEmp onEmpAdded={this.onEmpAdded} depts={this.state.depts}/>
            <ListEmp employees={this.state.employees} depts={this.state.depts}/>
            <br /><br />
            <AddDept onDeptAdded={this.onDeptAdded}/>
            <ListDept depts={this.state.depts} />
        </React.Fragment>
        );
    }
}

export default EmployeeComponent;