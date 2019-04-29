package com.luv2code.springboot.demo.springdemo.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.luv2code.springboot.demo.springdemo.dao.EmployeeRepository;
import com.luv2code.springboot.demo.springdemo.entity.Employee;

//Retrieve all Students - @GetMapping(“/students”)
//Get details of specific student - @GetMapping(“/students/{id}”)
//Delete a student - @DeleteMapping(“/students/{id}”)
//Create a new student - @PostMapping(“/students”)
//Update student details - @PutMapping(“/students/{id}”)

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@GetMapping("/employees")
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@GetMapping("/employees/{id}")
	public Employee findById(@PathVariable int id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		if (!employee.isPresent())
			throw new RuntimeException("Couldn't find the item by the id" + id);
		return employee.get();
	}

	@DeleteMapping("/employee/{id}")
	public void deleteEmployee(@PathVariable int id) {
		employeeRepository.deleteById(id);
	}

	@PutMapping("/employee/{id}")
	public ResponseEntity<Object> updateEmployee(@RequestBody Employee employee, @PathVariable int id) {
		Optional<Employee> employeeOptional = employeeRepository.findById(id);
		if (!employeeOptional.isPresent())
			return ResponseEntity.notFound().build();
		employee.setId(id);
		employeeRepository.save(employee);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping("/employees")
	public ResponseEntity<Object> saveEmployee(@RequestBody Employee theEmployee){
		Employee saveEmployee= employeeRepository.save(theEmployee);
		URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(saveEmployee.getId()).toUri();
		return ResponseEntity.created(location).build();
		
		
		
	}

}
