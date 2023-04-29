package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Personne;
import com.example.demo.entities.Role;
import com.example.demo.services.PersonneService;

@RestController
@RequestMapping("api/personnes")
public class PersonneController {

	
	@Autowired
	PersonneService personneService;

	@GetMapping("/role")
	public List<Personne> findPersonneByRole(@RequestBody Role role) {
		return personneService.findPersonneByRole(role);
	}
	
	
}
