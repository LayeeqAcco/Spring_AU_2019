package com.assignment.soap;

import java.util.ArrayList;

public class PersonFunctions {
	//arraylist to hold person details
	static ArrayList <Person> persons= new ArrayList <Person> ();
	
	//static block contains default persons
	static {
		persons.add(new Person(121,"Laker",21));
		persons.add(new Person(122,"Drazel",25));
		persons.add(new Person(123,"Nick",23));
	}
	
	//method to add new person details
	public String insert(int id, String name, int age) {
		for(Person temp: persons)
			if(temp.getId() == id)	//checking if id already exists
				return "ID already exists --> Insert failed";
		
		persons.add(new Person(id,name,age));
		return "Insert Success";
	}
	
	//method to get person details through id
	public String read(int id) {
		for(Person temp: persons) 
			if(temp.getId() == id) 
				return temp.toString();
		return "No Person with id= "+id; 
	}
	
	//method to get details of all persons
	public String readAll() {
		if(persons.isEmpty())
			return "No Persons in List";
		
		StringBuilder temp = new StringBuilder();
		temp.append("Person Details:");
		for(Person p: persons) {
			temp.append("\n");
			temp.append(p.toString());
		}
		return new String(temp);
	}
	
	//method to update person details through id
	public String update(int id, String name, int age) {
		for(Person temp:persons)
			if(temp.getId() == id) {
				temp.setAge(age);
				temp.setName(name);
				return "Update Success";
			}
		return "No Person with id= "+id + " Update Failed";
	}
	
	//method to delete a person details
	public String delete(int id) {
		for(Person temp:persons)
			if(temp.getId() == id) {
				persons.remove(temp);
				return "Delete Success";
			}
		return "No Person with id= "+id + " Delete Failed";
	}
}
