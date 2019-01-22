package com.assignment.maven;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
    	List<Student>studentList= new ArrayList<Student>();
    	
    	SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session=factory.openSession();
        session.beginTransaction();
        
        //uncomment below code and modify to add new student
        
        /*
        Student stud = new Student();
		stud.setStudentId(4);
		stud.setStudentName("Kirti");
		stud.setStudentAge(21);
		session.save(stud);
		*/
        /*
        Student stud = new Student();
		stud.setStudentId(5);
		stud.setStudentName("Krutika");
		stud.setStudentAge(22);
		session.save(stud);
        */
        /*
        Student stud = new Student();
		stud.setStudentId(3);
		stud.setStudentName("Ayushi");
		stud.setStudentAge(22);
		session.save(stud);
		*/
        //refer StudentTable screenshot
        
        /*
        Course c = new Course();
		c.setCourseName("Maven");
		c.setStudentId(4);
		session.save(c);
        */
        /*
        Course c = new Course();
		c.setCourseName("Maven");
		c.setStudentId(5);
		session.save(c);
		*/
        /*
		Course c = new Course();
		c.setCourseName("Spring");
		c.setStudentId(4);
		session.save(c);
        */
        /*
        Course c = new Course();
		c.setCourseName("Spring");
		c.setStudentId(3);
		session.save(c);
		*/
        
        @SuppressWarnings("deprecation")
		Criteria crit = session.createCriteria(Student.class);
        studentList= crit.list();
        System.out.println("NAME|AGE|ID|COURSE_NAME");
        for(Student student: studentList) {
   		 System.out.println( student.getStudentName()+"|" +student.getStudentAge()+"|"
   		 +student.getStudentId()+"|"
   		 +(!student.getCourses().isEmpty()?student.getCourses().get(0).getCourseName()
   		 :"") ); }
        
		session.getTransaction().commit();
		
    }
}
