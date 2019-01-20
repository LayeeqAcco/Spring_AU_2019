package com.assignment.soap;

public class PersonInterface {
	PersonFunctions myPerson = new PersonFunctions();
	
	//push new person details
	public String insert(int id, String name, int age) {
		return myPerson.insert(id, name, age);
	}
	
	//get details of all persons
	public String readAll() {
		return myPerson.readAll();
	}
	
	//get person details through id
	public String read(int id) {
		return myPerson.read(id);
	}
	
	//update person's name and age through id
	public String update(int id, String name, int age) {
		return myPerson.update(id, name, age);
	}
	
	//delete a Person through id
	public String delete(int id) {
		return myPerson.delete(id);
	}
}
