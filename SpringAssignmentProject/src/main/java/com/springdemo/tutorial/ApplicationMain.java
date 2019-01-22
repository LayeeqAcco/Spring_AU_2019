package com.springdemo.tutorial;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationMain {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext  = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		JDBCTemplateDao jdbcTemplateDao = (JDBCTemplateDao) applicationContext.getBean(JDBCTemplateDao.class);
		/*
		Student student = new Student();
		student.setStudentId(14);
		student.setStudentName("Acco");
		jdbcTemplateDao.saveStudent(student);
		*/
		
		List<Student> studList = jdbcTemplateDao.getStudentsListMax5();
		System.out.println("\nStudent List:");
		for(Student stud : studList)
			System.out.println(stud);
		
		
	}
	
}
