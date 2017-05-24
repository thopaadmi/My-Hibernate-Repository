package com.shravan.hibernate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="STUDENT")
public class Student {
	
	@Id
	@GeneratedValue
	private int student_id;
	
	private String student_name;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private StudentAddress studentaddress;
	
	public StudentAddress getStudentaddress() {
		return studentaddress;
	}
	public void setStudentaddress(StudentAddress studentaddress) {
		this.studentaddress = studentaddress;
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	
}
