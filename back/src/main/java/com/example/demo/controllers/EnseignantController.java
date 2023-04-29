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

import com.example.demo.entities.Enseignant;
import com.example.demo.services.EnseignantService;

@RestController
@RequestMapping("api/enseignants")
public class EnseignantController {

	
	@Autowired
	EnseignantService enseignantService;

	
	@GetMapping("/matricule/{matricule}")
	public Enseignant findByMatricule(@PathVariable String matricule) {
		return enseignantService.findByMatricule(matricule);
	}

	@PostMapping("/save")
	public Enseignant save(@RequestBody Enseignant p) {
		return enseignantService.save(p);
	}

	@GetMapping("/all")
	public List<Enseignant> findAll() {
		return enseignantService.findAll();
	}

	@GetMapping("/id/{id}")
	public Enseignant findById(@PathVariable int id) {
		return enseignantService.findById(id);
	}

	@PutMapping("/update")
	public Enseignant update(@RequestBody Enseignant p) {
		return enseignantService.update(p);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		enseignantService.delete(id);
	}
	
	
}
