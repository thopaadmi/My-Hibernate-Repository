package com.shravan.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main{
	public static void main(String args[]){
		
		Student_Detail student1 = new Student_Detail();
		student1.setStudent_mobile_no("**********");
		
		Student_Info student = new Student_Info();
		student.setName("Shravan");
		
		student1.setStudent_info(student);
	
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory(); 
		Session session = sessionFactory.openSession(); 
		session.beginTransaction(); 
		// this would save the Student_Info object into the database
		session.save(student1); // this will save both the student in both tables it seems . Lets see !!!
		session.getTransaction().commit();
		session.close(); 
		sessionFactory.close();
	}
}