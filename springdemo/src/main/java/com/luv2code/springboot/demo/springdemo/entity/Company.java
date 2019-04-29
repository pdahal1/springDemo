package com.luv2code.springboot.demo.springdemo.entity;

import java.util.List;




import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import javax.persistence.Id;
//import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;



@Entity
@Table(name="company")

public class Company {

	
// defined the fields
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="id")
private int Id;


@Column(name="NAME")
private String Name;


@Column(name="LOCATION")
private String Location;


@Column(name="DOMAIN")
private String Domain;


@Column(name="YEAR")
private int Year;


//@OneToMany(mappedBy="company", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
//@JoinColumn(name = "company_Id")
//private Department department;
//private List<Department> departments;
// defined the constructors without the fields .. 

// 0-args constr is required by the hibernate law ----

public Company() {
	
}

//defined the constructors with the field....

public Company(String name, String location, String domain, int year) {
	
	this.Name = name;
	this.Location = location;
	this.Domain = domain;
	this.Year = year;
	
}


//define the getters and setters

public int getId() {
	return Id;
}

public void setId(int id) {
	Id = id;
}

public String getName() {
	return Name;
}

public void setName(String name) {
	Name = name;
}

public String getLocation() {
	return Location;
}

public void setLocation(String location) {
	Location = location;
}

public String getDomain() {
	return Domain;
}

public void setDomain(String domain) {
	Domain = domain;
}

public int getYear() {
	return Year;
}

public void setYear(int year) {
	Year = year;
}

// generating getters and setters for department -------



//public List<Department> getDepartments() {
//	return departments;
//}
//
//public void setDepartments(List<Department> departments) {
//	this.departments = departments;
//}





//defined the toString methods


@Override
public String toString() {
	return "Company [Id=" + Id + ", Name=" + Name + ", Location=" + Location + ", Domain=" + Domain + ", Year=" + Year
			+ "]";
}



		
	
}
