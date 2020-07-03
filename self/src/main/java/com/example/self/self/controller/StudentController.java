package com.example.self.self.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.self.self.Repository.StudentRepository;
import com.example.self.self.entity.Student;

@RestController
@CrossOrigin("*")
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping("/students")
	public List<Student> findAll(){
		return studentRepository.findAll();
	}
	
	@GetMapping("/students/{id}")
	public Student findById(@PathVariable int id) {
		Optional<Student> optStudent= studentRepository.findById(id);
		if(!optStudent.isPresent())
			throw new RuntimeException("Can't find the id that you are looknig to display");
		return optStudent.get();
		
	}
	@PostMapping("/students")
	public void saveStudent(@RequestBody Student theStudent) {
		studentRepository.save(theStudent);
	}
	@PutMapping("/students/{id}")
	public ResponseEntity<Object> updateStudent(@RequestBody Student theStudent, @PathVariable int id){
		Optional <Student > optStudent= studentRepository.findById(id);
		if(!optStudent.isPresent())
			return ResponseEntity.notFound().build();
		studentRepository.save(theStudent);
		return ResponseEntity.noContent().build();
	}
	@DeleteMapping("/students/{id}")
	public void deleteStudent(@PathVariable int id){
		Optional <Student> optStudent = studentRepository.findById(id);
		if (!optStudent.isPresent())
			throw new RuntimeException("Can't delte if i don't findit");
		studentRepository.deleteById(id);
		
		
	}
	
	
	
	
	

}
