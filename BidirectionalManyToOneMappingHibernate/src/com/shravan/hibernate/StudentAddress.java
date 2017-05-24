package com.shravan.hibernate;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="StudentAddress")
public class StudentAddress {

	@Id
	@GeneratedValue(generator="seqN")
	@SequenceGenerator(name="seqN",sequenceName="seqN", allocationSize=1)
	private int address_id;
	
	@OneToMany( cascade = CascadeType.ALL )
	@JoinColumn(name="studentaddress_address_id",referencedColumnName="address_id")
	private Set<Student> students = new HashSet<Student>(0);;
	// Tried all kinds of combinations 
	// earlier was getting null value with using mappedBy attribute
	// finally settled for @JoinColumn annotation 
	// here the name property is important as it has to be exactly studentaddress_address_id or else
	// its giving an extra column with some other name with the value and the other 
	// column comes up as studentaddress_address_id with null
	
	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public int getAddress_id() {
		return address_id;
	}

	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}

	public String getAddress_detail() {
		return address_detail;
	}

	public void setAddress_detail(String address_detail) {
		this.address_detail = address_detail;
	}

	private String address_detail;
	
}
