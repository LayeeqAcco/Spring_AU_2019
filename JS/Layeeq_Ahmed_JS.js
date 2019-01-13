function person(first, last, age){
    this.fn = first;
    this.ln = last;
    this.age = age;
}

//adding a method to display person details
person.prototype.person_details=function(){
    console.log("First Name: " + this.fn);
    console.log("Last Name: " + this.ln);
    console.log("Age: " + this.age);
}

var per1 = new person("Lay", "Kar", "22");
per1.person_details();

function employee(id,sal,first,last,age){
    this.emp_id = id;
    this.salary = sal;
    person.call(this,first,last,age);
}

//creating a compound object with employee details
var emp1 = new employee("1234","100000");

//adding the person details to it through assign method
emp1 = Object.assign(emp1,per1);

function manager(id,sal,fir,las,age,title,pep){
    employee.call(this,id,sal,fir,las,age);
    this.proj_title = title;
    this.people = pep;      //no of people handled
    this.man_details = function(){
        console.log("First Name: " + this.fn);
        console.log("Last Name: " + this.ln);
        console.log("Age: " + this.age);
        console.log("Project Title: " + this.proj_title);
        console.log("People: " + this.people); 
        }
}

//create a new manager object
var man1 = new manager();
man1.proj_title = "MORGAN";
man1.people = 10;

//linking manager object to employee object
//emp1 is a manager--->man1
var man1 = Object.assign(man1,emp1);

//create another manager object by specifying details directly
var man2 = new manager("1444","200000","Karun","Nair","33", "STANLEY", 15);

//defining method outside
//using call
var details1 = per1.person_details;
details1.call(per1);
    
//using bind
var details2 = man1.man_details;
details2 = details2.bind(man1);
details2();

function hr(id,sal,fir,las,age,ev){
    employee.call(this,id,sal,fir,las,age);
    this.events = ev;
}

var hr_obj1 = new hr(1321, 1000000, "Trial", "Per", 28, 10);
var hr_obj2 = new hr(1222, 200000, "Next", "Gen", 29, 11);

//add to prototype
hr.__proto__.type = "Permanent";


