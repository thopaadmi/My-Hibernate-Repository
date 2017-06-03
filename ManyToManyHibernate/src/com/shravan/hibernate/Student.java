package com.shravan.hibernate;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="STUDENT")
public class Student {

	@Id
	@GeneratedValue(generator="seqN")
	@SequenceGenerator(name="seqN",sequenceName="seqN", allocationSize=1)
	private int Student_id;
	
	// Generating the sequence is very important . Without it we get abrupt numbers as ids for Student
	// and certification, which convey the right meaning but look abrupt. Here Shravan was geting 1, Thopaadmi 4 and
	// Java was getting 2 and Oracle as 3
	
	public String getStudent_name() {
		return Student_name;
	}

	public void setStudent_name(String student_name) {
		Student_name = student_name;
	}

	private String Student_name;
	
	@ManyToMany(cascade= CascadeType.ALL)
	@JoinTable(name = "STUDENT_STUDENT_CERTIFICATION", joinColumns = { @JoinColumn(name = "Student_id") }, inverseJoinColumns = { @JoinColumn(name = "certification_id") })
	private Set<StudentCertification> studentCertification = new HashSet<StudentCertification>(0);
	
	public Set<StudentCertification> getStudentCertification() {
		return studentCertification;
	}

	public void setStudentCertification(Set<StudentCertification> studentCertification) {
		this.studentCertification = studentCertification;
	}

	public int getStudent_id() {
		return Student_id;
	}

	public void setStudent_id(int student_id) {
		Student_id = student_id;
	}


	
	
	
}
