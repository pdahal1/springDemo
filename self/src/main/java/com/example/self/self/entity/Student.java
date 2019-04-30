package com.example.self.self.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "studentId")
	private int studentId;

	@Column(name = "firstName")
	private String firstName;

	@Column(name = "LastName")
	private String LastName;

	@Column(name = "major")
	private String major;

	@Column(name = "gradYear")
	private int gradYear;

	public Student() {
	}

	public Student(int studentId, String firstName, String lastName, String major, int gradYear) {

		this.studentId = studentId;
		this.firstName = firstName;
		LastName = lastName;
		this.major = major;
		this.gradYear = gradYear;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getGradYear() {
		return gradYear;
	}

	public void setGradYear(int gradYear) {
		this.gradYear = gradYear;
	}
}
