package com.assignment.junit;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.opencsv.CSVReader;

public class App 
{
    public static String inputFile = "input.csv";
    public static String outputFile = "output.csv";

    public List<Student> fileInput(String file) throws IOException{
    	List<Student> studList = new ArrayList<>();
    	List<Integer> scores;
    	CSVReader csvReader = new CSVReader(new FileReader(file));
    	Student stud;
    	String[] row;
    	
    	while((row = csvReader.readNext()) != null) {
    		//row has non - null value
    		stud = new Student();
    		stud.setStudentId(Integer.parseInt(row[0]));
    		stud.setStudentName(row[1]);
    		stud.setDateOfBirth(row[2]);
    		
    		scores = new ArrayList<Integer>();
    		scores.add(Integer.parseInt(row[3]));
    		scores.add(Integer.parseInt(row[4]));
    		stud.setStudentScores(scores);
    		
    		stud.setTotalScore();
    		studList.add(stud);
    	}
    	return studList;
    }
    
    public void fileOutput(List<Student> studList, String file) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
		int count = 1;
		String outString = "";
		for (Student stud : studList) {
			outString = outString + count + ", " 
					+ stud.getStudentId() + ", " 
					+ stud.getStudentName() + ", " 
					+ stud.getDateOfBirth() + ", " 
					+ stud.getPercentile() + "\n";
			count++;
		}

		bufferedWriter.write(outString);
		bufferedWriter.close();
	}
    
    public void sortStudents(List<Student> studList) {
    	for(Student stud : studList)
    		stud.setPercentile();
    	Collections.sort(studList, new StudentComparator());
    }
    
	public static void main( String[] args )
    {
        App myApp = new App();
        List<Student> studList = null;
        try {
        studList = myApp.fileInput(inputFile);
        }
        catch(IOException e) {
        	e.printStackTrace();
        }
        for(Student stud: studList)
        	if(Student.maxScore < stud.getTotalScore())
        		Student.maxScore = stud.getTotalScore();
        myApp.sortStudents(studList);
        try {
        	myApp.fileOutput(studList, outputFile);
        }
        catch(IOException e) {
        	e.printStackTrace();
        }
    }
}
