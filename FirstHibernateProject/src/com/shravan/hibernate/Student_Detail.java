package com.shravan.hibernate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;



@Entity
@Table(name="STUDENTDETAIL")
public class Student_Detail {
	
	
	@Id @GeneratedValue(generator="newGenerator") //name of the primary key generator
	@GenericGenerator(name="newGenerator",strategy = "foreign",parameters = { @Parameter(value="student_info",name="property")})
	
	private int roll_no;
	
	private String student_mobile_no;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "roll_no")
	private Student_Info student_info;
	// The column name of the class Student_info with which the mapping is to
	//be done is mentioned in the JoinColumn annotation
	
	public Student_Info getStudent_info() {
		return student_info;
	}
	public void setStudent_info(Student_Info student_info) {
		this.student_info = student_info;
	}
	public int getRoll_no() {
		return roll_no;
	}
	public void setRoll_no(int roll_no) {
		this.roll_no = roll_no;
	}
	public String getStudent_mobile_no() {
		return student_mobile_no;
	}
	public void setStudent_mobile_no(String student_mobile_no) {
		this.student_mobile_no = student_mobile_no;
	}


	
	
}
