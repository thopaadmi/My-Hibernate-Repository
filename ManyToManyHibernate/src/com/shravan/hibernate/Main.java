package com.shravan.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Student s1 = new Student();
		s1.setStudent_name("Shravan");
		
		Student s2 = new Student();
		s2.setStudent_name("ThopAadmi");

		StudentCertification sc1 = new StudentCertification();
		sc1.setCertification_name("JAVA Certification");
		
		StudentCertification sc2 = new StudentCertification();
		sc2.setCertification_name("ORACLE administrator");
		
		s1.getStudentCertification().add(sc1);
		s1.getStudentCertification().add(sc2);
		
		s2.getStudentCertification().add(sc1);
		s2.getStudentCertification().add(sc2);
		
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s= sf.openSession();
		s.beginTransaction();
		s.save(s1);
		s.save(s2);
		s.getTransaction().commit();
		s.close();
		sf.close();
		
	}

}
