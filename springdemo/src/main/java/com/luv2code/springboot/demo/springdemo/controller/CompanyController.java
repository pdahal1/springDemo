package com.luv2code.springboot.demo.springdemo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

	@GetMapping("/companies/{companyId}")
	public Company getCompany(@PathVariable int companyId) {
		Optional<Company> theCompany = companyRepository.findById(companyId);
		Company tc = null;
		if (theCompany.isPresent()) {
			tc = theCompany.get();
		} else {
			throw new RuntimeException("CompanyId is not found __________" + companyId);

		}
		return tc;
	}

	@PostMapping("/companies")
	public Company addCompany(@RequestBody Company theCompany) {
		// if the usr pass an Id of 0 in the Json format , set the Id =0
		// else if save it as update of the Id
		theCompany.setId(0);
		companyRepository.save(theCompany);
		return theCompany;
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