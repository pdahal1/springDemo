package com.luv2code.springboot.demo.springdemo.entity;

import java.util.List;

import javax.persistence.*;

@Entity
@Table (name = "employee")
public class Employee {
	
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name = "id")
private int Id;

@Column(name ="LEAD")
private String Lead;

@Column(name = "NAME")
private String Name;

@Column(name ="ADDRESS")
private String Address;

@Column(name ="Age")
private int Age;


//
//@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
//@JoinColumn(name = "employee_ID")
//private Team team;
//	
//private List<Team> teams;
//




//// 0 args constr
public Employee() {

}
// defing the const --
public Employee(String lead, String name, String address, int age) {
	
	Lead = lead;
	Name = name;
	Address = address;
	Age = age;
}

//defined the getters and setters ---
public int getId() {
	return Id;
}
public void setId(int id) {
	Id = id;
}
public String getLead() {
	return Lead;
}
public void setLead(String lead) {
	Lead = lead;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public String getAddress() {
	return Address;
}
public void setAddress(String address) {
	Address = address;
}
public int getAge() {
	return Age;
}
public void setAge(int age) {
	Age = age;
}


// defined the toString method --
@Override
public String toString() {
	return "Employee [Id=" + Id + ", Lead=" + Lead + ", Name=" + Name + ", Address=" + Address + ", Age=" + Age + "]";
}







}
