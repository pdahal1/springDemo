package com.luv2code.springboot.demo.springdemo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.luv2code.springboot.demo.springdemo.dao.DepartmentRepository;
import com.luv2code.springboot.demo.springdemo.entity.Department;
import java.net.URI;

//Retrieve all Students - @GetMapping(“/students”)
//Get details of specific student - @GetMapping(“/students/{id}”)
//Delete a student - @DeleteMapping(“/students/{id}”)
//Create a new student - @PostMapping(“/students”)
//Update student details - @PutMapping(“/students/{id}”)

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api")
public class DepartmentController {

	@Autowired
	private DepartmentRepository departmentRepository;

	@GetMapping("/Departments")
	public List<Department> findAll() {
		return departmentRepository.findAll();
	}

	@GetMapping("/Departments/{id}")
	public Department findById(@PathVariable int theId) {
		Optional<Department> Result = departmentRepository.findById(theId);
		if (!Result.isPresent())
			throw new RuntimeException("Couldn't find what you are trying to display");
		return Result.get();
	}
	
	@DeleteMapping("/Departments/{id}")
	public void deleteDepartment(@PathVariable int id) {
		departmentRepository.deleteById(id);
	}
	
	@PostMapping("/students")
	public ResponseEntity<Object> createDepartment(@RequestBody Department department) {
		Department savedDepartment = departmentRepository.save(department);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedDepartment.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	

	@PutMapping("/Departments/{id}")
	public ResponseEntity<Object> updateStudent(@RequestBody Department department, @PathVariable int id) {
		Optional<Department> DepartmentOptional = departmentRepository.findById(id);
		if (!DepartmentOptional.isPresent())
			return ResponseEntity.notFound().build();
		department.setId(id);
		departmentRepository.save(department);
		return ResponseEntity.noContent().build();
	}
}
