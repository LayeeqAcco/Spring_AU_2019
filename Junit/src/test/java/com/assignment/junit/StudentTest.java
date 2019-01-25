package com.assignment.junit;

import static org.junit.Assert.assertEquals;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.opencsv.CSVReader;

public class StudentTest {
	Student stud;
	App myApp;
	
	@Before
	public void setup() {
		stud = new Student();
		myApp = new App();
	}
	
	@Test
	public void readFileTest() throws IOException {
		List<Student> studentList = myApp.fileInput(App.inputFile);
		assertEquals(100, studentList.size());
	}
	

	@Test
	public void checkWriteToCsv() throws IOException {
		List<Student> studList = null;
		String[] row;
		int count = 0;
		
		studList = myApp.fileInput(App.inputFile);
		myApp.fileOutput(studList, App.outputFile);
		
		CSVReader csvReader = new CSVReader(new FileReader(App.outputFile));
		while ((row = csvReader.readNext()) != null) 	
			count++;
		
		assertEquals(100, count);
		csvReader.close();
	}
	
	@Test(expected = IOException.class)
	public void exceptionInputTest() throws IOException {
		myApp.fileInput("invalid");
	}
	
	@Test(expected = IOException.class)
	public void exceptionOutputTest() throws IOException {
		List<Student> studList = new ArrayList<>();
		myApp.fileOutput(studList, null);
	}
	
	@Test
	public void checkWriteToCsvMock() throws IOException {
		App appMock = Mockito.mock(App.class);
		List<Student> studList = myApp.fileInput(App.inputFile);
		
		appMock.fileOutput(studList, App.outputFile);
		
		Mockito.verify(appMock, Mockito.times(1)).fileOutput(studList, App.outputFile);
	}
	
	@Test
	public void checkHighest() throws IOException {
		List<Student> studList = myApp.fileInput(App.inputFile);
		for(Student stud: studList)
        	if(Student.maxScore < stud.getTotalScore())
        		Student.maxScore = stud.getTotalScore();
        myApp.sortStudents(studList);
		assertEquals("Cristine", studList.get(0).getStudentName());
	}
	
	@Test
	public void checkStudentGetAndSet() {
		stud = new Student();
		
		stud.setStudentId(4434);
		stud.setStudentName("Test");
		stud.setDateOfBirth("20/03/1998");
		
		List<Integer> scores = new ArrayList<> ();
		scores.add(50);
		scores.add(42);
		stud.setStudentScores(scores);
		stud.setTotalScore();
		//maxScore = 184;

		stud.setTotalScore();
		stud.setPercentile();
		
		assertEquals(4434, stud.getStudentId());
		assertEquals("Test", stud.getStudentName());
		assertEquals("20/03/1998", stud.getDateOfBirth());
		assertEquals(2, stud.getStudentScores().size());
		assertEquals(50, stud.getPercentile(), 2);
		
		System.out.println(stud.toString());
	}
	
	@Test(timeout=1000)
	public void mainMethodTest() {
		App.main(null);
	}
}
