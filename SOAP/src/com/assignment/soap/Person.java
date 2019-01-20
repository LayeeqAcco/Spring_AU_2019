package com.assignment.soap;

public class Person {
	//details
	private int id, age;
	private String name;
	
	//parameterized constructor
	Person(int id, String name, int age){
		this.id = id;
		this.age = age;
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}
	
	//overriding toString method to get Person details for output
	@Override
	public String toString() {
		return "EmpID: " + id + " Name: " + name + " Age: " + age;
	}
	
}
