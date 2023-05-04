package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Salle;
import com.example.demo.models.TypeSalle;
import com.example.demo.services.SalleService;

@RestController
@RequestMapping("api/salles")
public class SalleController {

	
	@Autowired
	SalleService salleService;

	@PostMapping("/save")
	public Salle save(@RequestBody Salle p) {
		return salleService.save(p);
	}

	@GetMapping("/all")
	public List<Salle> findAll() {
		return salleService.findAll();
	}

	@GetMapping("/id/{id}")
	public Salle findById(@PathVariable int id) {
		return salleService.findById(id);
	}

	@PutMapping("/update")
	public void update(@RequestBody Salle p) {
		 salleService.update(p);
	}

	@DeleteMapping("/delete")
	public void delete(@RequestBody Salle p) {
		salleService.delete(p);
	}

	@GetMapping("/type")
	public List<Salle> findSalleByType(@RequestBody TypeSalle nom) {
		return salleService.findSalleByType(nom);
	}
	
	
	
}
