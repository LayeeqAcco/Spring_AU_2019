package com.spring.au.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.au.model.Student;

//Mapper for handling Student records
public class StudentMapper implements RowMapper<Student>{
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student student = new Student();
		student.setStudentId(rs.getInt("studentId"));
		student.setStudentAge(rs.getInt("studentAge"));
		student.setStudentName(rs.getString("studentName"));
		return student;
	}
}
