package com.assignment.junit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;

public class StudentComparator implements Comparator<Student>{

	private static SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
	
	@Override
	public int compare(Student o1, Student o2) {
		if(o2.getPercentile() == o1.getPercentile()) {
			try {
			return sdf.parse(o1.getDateOfBirth()).compareTo(sdf.parse(o2.getDateOfBirth()));
			}
		catch(ParseException e) {e.printStackTrace();}
		}
		if (o2.getPercentile() > o1.getPercentile())
			return 1;
		return -1;
	}
	
}
