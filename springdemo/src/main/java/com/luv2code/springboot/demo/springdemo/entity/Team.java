package com.luv2code.springboot.demo.springdemo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;

@Entity
@Table(name = "team")
public class Team {

// defined the fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int Id;

	@Column(name = "Team_Name")
	private String Name;

	@Column(name = "Team_Members")
	private int Members;

	@Column(name = "Team_Manager")
	private String Manager;

	@ManyToOne(optional = false)
	@JoinColumn(name = "department", referencedColumnName = "id")
	private Department department;

// Relation with employee table
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "id")
	private List<Employee> employees;

	public Team() {

	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public Team(String name, int members, String manager) {
		this.Name = name;
		this.Members = members;
		this.Manager = manager;
	}

//defined the getters and setters

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getMembers() {
		return Members;
	}

	public void setMembers(int members) {
		Members = members;
	}

	public String getManager() {
		return Manager;
	}

	public void setManager(String manager) {
		Manager = manager;
	}

// defined getters and setters for the department ....

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

// defined the getters and setters for the employee table ----

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

//defined the toString ---
	@Override
	public String toString() {
		return "Team [Id=" + Id + ", Name=" + Name + ", Members=" + Members + ", Manager=" + Manager + "]";
	}

}
