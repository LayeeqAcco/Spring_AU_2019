package com.spring.au.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.au.dao.impl.StudentDAO;
import com.spring.au.model.Student;

@Service
public class StudentService {

	@Autowired
	StudentDAO studentDao;
	
	public String getName(int id) {
		 return "Name = " + studentDao.getName(id);
	}

	public String insertStudent(Student student) {
		if(studentDao.insertStudent(student)==1)	//1 row added
			return "Insert Success";
		return "Insert Failure";
	}

	public List<Student> getAllStudentDetails() {
		return studentDao.getAllStudentDetails();
	}
}
