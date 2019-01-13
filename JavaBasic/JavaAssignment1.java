package com.accolite.assignment1;

//basic interface for any person
interface BasicDetails{
	public String getName();
	public void setName(String fname,String lname);
	public void setAge(int age);
	public int getAge();
}

//Employee class with BasicDetails interface
class Employee implements BasicDetails{
	protected static String companyName;
	protected int age, salary;
	protected String fname, lname;
	
	//static block --> executed once only
	static {
		companyName = "ACCOLITE";
		System.out.println("Company name set");
	}
	
	//instance block --> executed for each instance of the class
	{
		System.out.println("\nEmployee instance created");
	}
	
	//Overloading Employee constructor
	//Default Constructor
	Employee(){
		System.out.println("\nDefault Employee Constructor");
		fname = null;
		lname = null;
	}
	
	//Parameterized Constructor
	Employee(String fname, String lname, int age, int salary){
		System.out.println("\nParameterized Employee Constructor");
		this.fname = fname;
		this.lname = lname;
		this.age = age;
		this.salary = salary;
	}
	
	public int getSalary() {
		return salary;
	}
	
	public int getAge() {
		return age;
	}
	
	public String getName() {
		return fname + " " + lname;
	}
	
	public void setName(String fname, String lname) {
		this.fname = fname;
		this.lname = lname;
	}
	
	//this method demonstrates ExceptionHandling
	public void setAge(int age) throws RuntimeException{
		if(age<=0)
			throw new RuntimeException("Invalid Age!");
		this.age = age;
	}
	
	public void setSalary(int sal) {
		salary = sal;
	}
	
	//method overriding
	public void printDetails() {
		System.out.println("EMPLOYEE DETAILS");
		System.out.println("Name: "+fname+" "+lname);
		System.out.println("Age: " + age);
		System.out.println("Company: "+ companyName);
		System.out.println("Salary: "+salary);
	}
	
	//static method
	public static String getCompanyName() {
		return companyName;
	}
}

//Manager class inherits Employee class
class Manager extends Employee{
	String project;
	
	//parameterized constructor
	Manager(String fname, String lname, int age, int salary, String project){
		super(fname,lname,age,salary);
		this.project = project;
		System.out.println("Manager Parameterized Constructor");
	}
	
	//default constructor
	Manager(){
		//auto invokes default constructor of super class
		System.out.println("Manager Default Constructor");
		project = "none";
	}
	
	public String getProject() {
		return project;
	}
	
	public void setProject(String p) {
		project = p;
	}
	
	//method overriding
	@Override
	public void printDetails() {
		System.out.println("\nMANAGER DETAILS");
		System.out.println("Name: "+fname+" "+lname);
		System.out.println("Age: " + age);
		System.out.println("Company: "+ companyName);
		System.out.println("Salary: "+salary);
		System.out.println("Project: "+project);
	}
		
}

//Developer class inherits Employee class
class Developer extends Employee{
	String devType;	//front end or back end
	
	//parameterized constructor
	Developer(String fname, String lname, int age, int salary, String devType){
		super(fname,lname,age,salary);
		this.devType = devType;
		System.out.println("Developer Parameterized Constructor");
	}
	
	//default constructor
	Developer(){
		//auto invokes default constructor of super class
		System.out.println("Developer Default Constructor");
		devType = "FrontEnd";
	}
	
	public void setDevType(String dt) {
		devType = dt;
	}
	
	public String getDevType() {
		return devType;
	}
	
	//method overriding
	@Override
	public void printDetails() {
		//another use of super keyword
		System.out.println("\nDEVELOPER DETAILS");
		super.printDetails();
		System.out.println("Developer Type: "+devType);
	}
}

public class JavaAssignment1{
	public static void main(String[] args) {
		
		//creating Manager object
		Employee manager1 = new Manager("Kapil","Agarwal",31,200000,"GlobalTech");
		//testing overridden call
		manager1.printDetails();	//manager class method is invoked here
		
		//invoking a static method
		System.out.println("\nSTATIC METHOD");
		System.out.println("Company Name: " + Employee.getCompanyName());
		
		//creating Developer object
		Employee dev1 = new Developer("Akhil","Kotakota",21,10000,"FrontEnd");
		dev1.printDetails();
		
		System.out.println("\nException Handling:");
		//checking for an exception
		try {
			dev1.setAge(-2);
		}
		//catching specific exception
		catch(RuntimeException e) {
			System.out.println("Exception Caught: " + e.getMessage());
		}
		//executing block regardless of whether exception caught or not
		finally {
			System.out.println("Current age: " + dev1.getAge());
		}
		
		//constructing object through default constructor
		//details added through public methods
		Developer dev2 = new Developer();
		dev2.setName("Akash", "Parihar");
		dev2.setAge(24);
		dev2.setSalary(100000);
		dev2.setDevType("BackEnd");
		dev2.printDetails();
	}
}