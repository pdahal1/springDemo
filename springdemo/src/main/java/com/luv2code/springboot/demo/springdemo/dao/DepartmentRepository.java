package com.luv2code.springboot.demo.springdemo.dao;
//import com.luv2code.springboot.demo.springdemo.entity.Company;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.luv2code.springboot.demo.springdemo.entity.Department;
@RepositoryRestResource
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    
}
