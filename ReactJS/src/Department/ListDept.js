import React, { Component } from 'react';
//import './ListEmp.css'

class ListDept extends Component{
    render(){
           console.log("Departments",this.props.depts);
        let newDept = this.props.depts.map((dept, i) =>{
            return i;
        });
        return (
            <div>
                <h1>List of Departments</h1>
                <table>
                    <tr>
                        <th>Name</th>
                        <th>Description</th>
                    </tr>
                
                {
                    this.props.depts && this.props.depts.map((dept, i)=>{
                        return(
                        <tr key = {dept.name}> 
                            <td>{dept.name}</td>
                            <td>{dept.description}</td>
                        </tr>
                    );
                })
            }
                </table>
            </div>
        );
    }
}

export default ListDept;