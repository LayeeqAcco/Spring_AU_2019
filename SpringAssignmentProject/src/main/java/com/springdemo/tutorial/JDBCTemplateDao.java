package com.springdemo.tutorial;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class JDBCTemplateDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int saveStudent(Student student){
		String query = "insert into student values "
				+ "("+student.getStudentId()+",'"+student.getStudentName()+"',"+student.getStudentAge()+")";
		return jdbcTemplate.update(query);
	}
	
	//method depicts use of ResultSet and RowMapper
	//returns max 5 Student records --> LIMIT 5
	public List<Student> getStudentsListMax5() {	
		return jdbcTemplate.query("select * from student limit 5;",new RowMapper<Student>(){
		    public Student mapRow(ResultSet resultset, int rownumber) throws SQLException {  
		    	Student stud = new Student();  
		        stud.setStudentId(resultset.getInt(1));  
		        stud.setStudentName(resultset.getString(2));  
		        stud.setStudentAge(resultset.getInt(3));  
		        return stud;
		    }  
		});
	}
	
	//method for returning all Students from JDBC to MVC
	public List<Student> getStudentsList() {	
		return jdbcTemplate.query("select * from student;",new RowMapper<Student>(){
		    public Student mapRow(ResultSet resultset, int rownumber) throws SQLException {  
		    	Student stud = new Student();  
		        stud.setStudentId(resultset.getInt(1));  
		        stud.setStudentName(resultset.getString(2));  
		        stud.setStudentAge(resultset.getInt(3));  
		        return stud;
		    }  
		});
	}
	
}
