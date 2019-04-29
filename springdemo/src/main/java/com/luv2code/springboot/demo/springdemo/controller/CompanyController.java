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

import com.luv2code.springboot.demo.springdemo.dao.CompanyRepository;
import com.luv2code.springboot.demo.springdemo.entity.Company;

@RestController
@RequestMapping("/api")
public class CompanyController {

	@Autowired
	private CompanyRepository companyRepository;

	@GetMapping("/companies")
	public List<Company> findAll() {
		return companyRepository.findAll();
	}

	@GetMapping("/companies/{id}")
	public Company findById(@PathVariable int id) {
		Optional <Company> optCompany= companyRepository.findById(id);
		if(!optCompany.isPresent())
			throw new RuntimeException("Could't find the id to retrive the detail");
		return optCompany.get();
		
	}

	@PostMapping("/companies")
	public ResponseEntity<Object> addCompany(@RequestBody Company theCompany){
		Company saveCompany=companyRepository.save(theCompany);
		URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(saveCompany.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping("/companies")
	public Company updateCompany(@RequestBody Company theCompany) {
		companyRepository.save(theCompany);
		return theCompany;
	}

	@DeleteMapping("/companies/{companyId}")
	public int deleteCompany(@PathVariable int companyId) {
		Optional<Company> tempCompany = companyRepository.findById(companyId);
		Company tc = null;
		if (tempCompany.isPresent()) {
			tc = tempCompany.get();
		} else {
			throw new RuntimeException("Company not found in the database -------" + companyId);
		}
		companyRepository.deleteById(companyId);
		return companyId;

	}

}