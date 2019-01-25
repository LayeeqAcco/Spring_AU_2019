package com.assignment.junit;

import java.util.List;

public class Student {
	private int studentId;
	private String studentName;
	private String dateOfBirth;
	private List<Integer> studentScores;
	private int totalScore;
	private float percentile;
	
	public static int maxScore;
	
	public int getStudentId() {
		return studentId;
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
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public List<Integer> getStudentScores() {
		return studentScores;
	}
	public void setStudentScores(List<Integer> studentScores) {
		this.studentScores = studentScores;
	}
	public int getTotalScore() {
		return totalScore;
	}
	public void setTotalScore() {
		int scoreCount = 0;
		for(int score: studentScores)
			scoreCount = scoreCount + score;
		totalScore = scoreCount;
	}
	public float getPercentile() {
		return percentile;
	}
	public void setPercentile() {
		this.percentile = (float)this.totalScore * 100 / maxScore;
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", dateOfBirth=" + dateOfBirth
				+ ", percentile=" + percentile + "]";
	}
	
}
