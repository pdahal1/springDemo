package com.luv2code.springboot.demo.springdemo.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.luv2code.springboot.demo.springdemo.dao.TeamRepository;
//import com.luv2code.springboot.demo.springdemo.entity.Company;
import com.luv2code.springboot.demo.springdemo.entity.Team;

@RestController
@RequestMapping("/api")
public class TeamController {

	@Autowired
	private TeamRepository teamRepository;
	
	
	@PutMapping("/teams/{id}")
	public ResponseEntity<Object> updateTeam(@RequestBody Team theTeam, @PathVariable int id){
		Optional <Team> optTeam= teamRepository.findById(id);
		if(!optTeam.isPresent()) 
			return ResponseEntity.notFound().build();
		theTeam.setId(id);
		teamRepository.save(theTeam);
		return ResponseEntity.noContent().build();
	
	}
	@PostMapping("/teams")
	public ResponseEntity<Object> saveTeam(@RequestBody Team theTeam){
		Team saveTeam= teamRepository.save(theTeam);
		URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(saveTeam.getId()).toUri();
		return ResponseEntity.created(location).build(); 
	}
	
	@GetMapping("/teams")
	public List<Team> findALL(){
		return teamRepository.findAll();
	}
	@GetMapping("/teams/{id}")
	public Team findByid(@PathVariable int id) {
		Optional<Team> optTeam= teamRepository.findById(id);
		if (!optTeam.isPresent())
			throw new RuntimeException("couldn't find what you are looking for ");
		return optTeam.get();
	}
}



	
