package com.luv2code.springboot.demo.springdemo.entity;

import java.util.List;






import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
//import javax.persistence.ForeignKey;



@Entity
@Table(name="department")

public class Department {

// defined the fields ---------------	
	
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="id")
private int Id;

@Column (name="Dept_Name")
private String Name;

@Column(name="Dept_Location")
private String Location;

//@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
//@JoinColumn(name = "department_ID")
//private Team team;

//private List<Team> teams;
//@OneToMany(mappedBy="department", cascade=CascadeType.ALL, fetch = FetchType.LAZY)

@ManyToOne(optional = false)
@JoinColumn(name = "company", referencedColumnName = "id")
private Company company;
	
//private List<Company> companies;

@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
@JoinColumn(name = "id")
private List<Team> teams;
	
// 0-Args constructor is created for the hibernate -------
	
public Department() {
	
}
//defined the contsructors

public Department(String name, String location) {
	
	Name = name;
	Location = location;
}

//  defined the getters and setters ---------


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


// defined getter and setters for the company ......

public Company getCompany() {
	return company;
}

public void setCompany(Company company) {
	this.company = company;
}

// defined the getters and setters for the teams......


public List<Team> getTeams() {
	return teams;
}

public void setTeams(List<Team> teams) {
	this.teams = teams;
}


//defined the toString method ...
@Override
public String toString() {
	return "Department [Id=" + Id + ", Name=" + Name + ", Location=" + Location + "]";
}










}
