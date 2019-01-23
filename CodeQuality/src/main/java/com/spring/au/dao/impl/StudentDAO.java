package com.spring.au.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.au.model.Student;
import com.spring.au.query.StudentQuery;
import com.spring.au.rowmapper.StudentMapper;

@Repository
public class StudentDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	StudentQuery studentQuery;
	
	//single result query
	public String getName(int id) {
		return jdbcTemplate.queryForObject(studentQuery.getNameQueryString(id),String.class);
	}

	//update --> inserting new student details recieved through POST
	public int insertStudent(Student student) {
		return jdbcTemplate.update(studentQuery.insertQueryString(student));
	}
	
	//method to retrieve details of all students through RowMapper implementation
	public List<Student> getAllStudentDetails() {
		return jdbcTemplate.query(studentQuery.getAllStudentQueryString(), new StudentMapper());
	}
	
}
