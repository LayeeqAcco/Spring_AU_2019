package com.spring.au.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.au.model.Student;
import com.spring.au.service.impl.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@GetMapping("/getName")
	public String getName(@RequestParam("id") int id) {
		return studentService.getName(id);
	}
	
	@GetMapping("/getAll")
	public List<Student> getAllStudentDetails() {
		return studentService.getAllStudentDetails();
	}
	
	@PostMapping("/insert")
	public String insertStudent(@RequestBody Student student) {
		return studentService.insertStudent(student);
	}
}
