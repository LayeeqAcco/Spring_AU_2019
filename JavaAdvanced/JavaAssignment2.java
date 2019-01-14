package com.accolite.assignment2;

import java.util.ArrayList;
import java.util.TreeSet;

//Address class
class Address{
	int houseNo;
	String street, area ,city, state;
	int pincode;
	
	//constructor
	Address(int h, String str, String area, String city, String st, int pc){
		houseNo = h;
		street = str;
		this.area = area;
		this.city = city;
		state = st;
		pincode = pc;
	}
	
	//method to get pincode
	public int getPincode() {
		return this.pincode;
	}
	
	//method to get city name
	public String getCity() {
		return this.city;
	}
	
	//method to print the full address
	public void printAddress() {
		System.out.println("ADDRESS: "+ houseNo + ", " + street + ", " + area + ", " + city + ", "
						+ state + " - " + pincode);
	}
}

//Employee class
class Employee implements Comparable<Employee>{
	private int id;
	private String fname, lname;
	private int age;
	
	//constructor
	Employee(int id, String fname, String lname, int age){
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.age = age;
	}
	
	//overriding compareTo method to store Employees in descending order of age in TreeSet
	@Override
	public int compareTo(Employee emp){
		return emp.age - this.age;
	}
	
	//method to print employee details
	public void printDetail() {
		System.out.println("ID: " + id + " Name: " + fname + " " + lname + 
				" Age: "+ age);
	}
	
	//method to get age of employee
	public int getAge() {
		return age;
	}
	
	//method to get full name of employee
	public String getName() {
		return fname + " " + lname;
	}
	
	//method to get ID of employee
	public int getId() {
		return id;
	}
}

//Company class
class Company{
	private String name;
	private Address addr;
	private TreeSet <Employee> employees;
	
	//constructor
	Company(String name, Address addr, TreeSet<Employee> emps) {
		this.name = name;
		this.addr = addr;
		employees = emps;
	}
	
	//method to return address of the company
	public Address getAddress() {
		return addr;
	}
	
	//method to return name of the company
	public String getName() {
		return name;
	}
	
	//method to add new employee to the company
	public void addNewEmployee(Employee emp) {
		employees.add(emp);
	}
	
	//method to print details of all employees
	public void printAllEmployeeDetails() {
		System.out.println("\nDetails of ALL employees:");
		for(Employee emp: employees)
			emp.printDetail();
	}
	
	//method to print details of employees having age less than 30
	public void employeesAgeLessThan30(){
		System.out.println("\nEmployees below age 30:");
		for(Employee emp: employees) {
			if(emp.getAge()<30) 
				emp.printDetail();
		}
	}
	
	//method to sort Employee details by name and print
	void sortEmployeesByName() {
		//defining new TreeSet using shorthand comparator
		TreeSet<Employee> temp = new TreeSet<Employee>((p1,p2) -> p1.getName().compareTo(p2.getName()));
		for(Employee emp: employees)
			temp.add(emp);
		System.out.println("\nSorted by Name:");
		JavaAssignment2.printEmployeeTreeSet(temp);
	}
	
	//method to sort Employee details by ID and print
	void sortEmployeesById() {
		//defining new TreeSet using shorthand comparator
		TreeSet<Employee> temp = new TreeSet<Employee>((p1,p2) -> p1.getId() - p2.getId());
		for(Employee emp: employees)
			temp.add(emp);
		System.out.println("\nSorted by ID:");
		JavaAssignment2.printEmployeeTreeSet(temp);
	}
}

public class JavaAssignment2 {
	public static void main(String[] args) {
		
		//creating TreeSet and filling it with employees for company1
		TreeSet <Employee> emps1 = new TreeSet <Employee> ();
		emps1.add(new Employee(121,"Kashish","Sharma",21));
		emps1.add(new Employee(135,"Khamar","Ali",23));
		emps1.add(new Employee(131, "Sunil", "Grover", 30));
		emps1.add(new Employee(123,"Amogh", "Vardhan", 22));
		//printEmployeeTreeSet(emps1);
		
		//address for company1
		Address addr1 = new Address(32,"2nd Main","Kormangala","Bengaluru","Karnataka",560214);
		
		//create company1 object
		Company company1 = new Company("Acco",addr1,emps1);
		
		//printing details of all employees
		company1.printAllEmployeeDetails();
		
		//printing employee details of employees having age less than 30 in company1
		company1.employeesAgeLessThan30();
		
		//sorted by ID
		company1.sortEmployeesById();
		
		//sorted by Name
		company1.sortEmployeesByName();
		
		//setting up company2
		TreeSet <Employee> emps2 = new TreeSet <Employee> ();
		emps2.add(new Employee(213,"Kashi","Varhan",21));
		Address addr2 = new Address(12,"3rd Cross","Dinnur","Bengaluru","Karnataka",560032);
		Company company2 = new Company("Walmarty",addr2,emps2);
		
		//adding new employee to company2
		company2.addNewEmployee(new Employee(225,"Kumar","Mishra",23));
		
		//setting up company3
		TreeSet <Employee> emps3 = new TreeSet <Employee> ();
		emps3.add(new Employee(131, "Sunil", "Shetty", 30));
		emps3.add(new Employee(123, "Amogh", "Singh", 22));
		
		Company company3 = new Company("Cityrix",
				new Address(134,"8th Main","Malleswaram","Mysore","Karnataka",561234), 
				emps3);
		
		//creating ArrayList of companies for printing company names city-wise
		ArrayList <Company> companies = new ArrayList<Company> ();
		companies.add(company1);
		companies.add(company2);
		companies.add(company3);
		
		companySameCity(companies);
	}
	
	static void printEmployeeTreeSet(TreeSet<Employee> employees) {
		for(Employee emp: employees) 
			emp.printDetail();
	}
	
	static void companySameCity(ArrayList<Company> companies) {
		System.out.println("\nCITYWISE COMPANY PRINT");
		ArrayList<Company> temp = new ArrayList<Company>();
		for(Company c1 : companies) {
			if(!temp.contains(c1)) {
				temp.add(c1);
				System.out.println("\nCITY: " + c1.getAddress().getCity());
				System.out.println(c1.getName());
				for(Company c2: companies) {
					if(c1!=c2 && c1.getAddress().getCity().equalsIgnoreCase(c2.getAddress().getCity())){
						System.out.println(c2.getName());
						temp.add(c2);
					}
				}
			}
		}
	}
}
