package com.spring.au.query;

import org.springframework.stereotype.Component;

import com.spring.au.model.Student;

@Component
public class StudentQuery {
	
	private String insertQuery = "insert into mydb.student values ";
	private String getNameQuery = "select studentName from student where studentId = ";
	private String getAllStudentQuery = "select * from student;";
	
	public String getNameQueryString(int id) {
		return getNameQuery + id;
	}
	
	public String insertQueryString(Student student) {
		return insertQuery + "("+student.getStudentId()+","+student.getStudentAge()+",'"+student.getStudentName()+"')";
	}
	
	public String getAllStudentQueryString() {
		return getAllStudentQuery;
	}
}
