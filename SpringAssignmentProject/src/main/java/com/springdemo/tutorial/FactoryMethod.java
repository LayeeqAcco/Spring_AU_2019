package com.springdemo.tutorial;

public class FactoryMethod {
	//method to create a dummy object through factory method
	public static Student createDummyStudent(){
		Student stud = new Student();
		stud.setStudentId(-1);
		stud.setStudentName("dummyName");
		stud.setStudentAge(-1);
		System.out.println("Dummy student created thorugh Factory Method!");
		System.out.println(stud);
		return stud;
	}
}
