package com.springdemo.tutorial.controller;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springdemo.tutorial.JDBCTemplateDao;
import com.springdemo.tutorial.Student;


@Controller
public class StudentController {
	
	//mapping initial call to servlet to index file to take student input
	@RequestMapping(value = "/")
	@ResponseBody
	public String starter() {
		return "index.jsp";
	}
	
	//print details of students
	@RequestMapping(value = "/getStudents",method=RequestMethod.GET,produces="application/json")
	@ResponseBody
	public List<Student> getStudents(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		JDBCTemplateDao jdbcTemplateDao = (JDBCTemplateDao) applicationContext.getBean(JDBCTemplateDao.class);
		List<Student> studList = jdbcTemplateDao.getStudentsList();
	    return studList;
	}
	
	/*
	@RequestMapping(value="/getStudent",method=RequestMethod.GET,produces = "application/json")
	@ResponseBody
	public Student getStudents(@RequestParam("id")int id){
		Student student = new Student();
	    student.setStudentId(id);
	    student.setStudentName("XYZ");
	    student.setStudentAge(22);
	    return student;
	}
	*/
	
	/*
	@RequestMapping(value="/getStudent/{id}",method=RequestMethod.GET,produces = "application/json")
	@ResponseBody
	public Student getStudent(@PathVariable("id")int id){
		Student student = new Student();
	    student.setStudentId(id);
	    student.setStudentName("XYZ");
	    student.setStudentAge(22);
	    return student;
	}
	*/
	
	//POST method to add students
	@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	public String addStudent(@RequestParam("id") int id, @RequestParam("name") String name, @RequestParam("age") int age) {
		Student stud = new Student();
		stud.setStudentId(id);
		stud.setStudentName(name);
		stud.setStudentAge(age);
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		JDBCTemplateDao jdbcTemplateDao = (JDBCTemplateDao) applicationContext.getBean(JDBCTemplateDao.class);
		try {
			jdbcTemplateDao.saveStudent(stud);
		}
		catch(Exception e){
			System.out.println(e);
			return "failure";
		}
		System.out.println("POST details: " + stud);
		return "success";
	}
	
	
	

}
