package com.shravan.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StudentAddress SA = new StudentAddress();
		SA.setAddress_detail("Hyderabad,India");
		
		Student s1 = new Student();
		s1.setStudent_name("Shravan");
		//s1.setStudentaddress(SA);
		
		Student s2 = new Student();
		s2.setStudent_name("Vipul");
		//s2.setStudentaddress(SA);
		
		SA.getStudents().add(s1);
		SA.getStudents().add(s2);
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		
		session.beginTransaction();
		//session.save(s1);
		//session.save(s2);
		session.save(SA);
		session.getTransaction().commit();
		session.close();
		sf.close();
	}

}
