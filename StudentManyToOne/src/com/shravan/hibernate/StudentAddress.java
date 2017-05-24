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
