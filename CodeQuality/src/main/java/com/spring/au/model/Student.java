package com.spring.au.model;

public class Student {
	
	int studentId;
	String studentName;
	int studentAge;
	
	public int getStudentId() {
		return studentId;
	}
	
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentAge=" + studentAge + "]";
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
	
	public String getStudentName() {
		return studentName;
	}
	
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	public int getStudentAge() {
		return studentAge;
	}
	
	public void setStudentAge(int studentAge) {
		this.studentAge = studentAge;
	}
	
}
