package com.luv2code.springboot.demo.springdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.luv2code.springboot.demo.springdemo.entity.Team;

@RepositoryRestResource
public interface TeamRepository extends JpaRepository<Team, Integer> {

}
