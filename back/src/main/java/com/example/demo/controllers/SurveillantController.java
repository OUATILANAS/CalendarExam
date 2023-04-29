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

import com.example.demo.entities.Surveillant;
import com.example.demo.services.SurveillantService;

@RestController
@RequestMapping("api/surveillants")
public class SurveillantController {

	
	@Autowired
	SurveillantService surveillantService;

	@GetMapping("/matricule/{matricule}")
	public Surveillant findByMatricule(@PathVariable String matricule) {
		return surveillantService.findByMatricule(matricule);
	}

	@PostMapping("/save")
	public Surveillant save(@RequestBody Surveillant p) {
		return surveillantService.save(p);
	}

	@GetMapping("/all")
	public List<Surveillant> findAll() {
		return surveillantService.findAll();
	}

	@GetMapping("/id/{id}")
	public Surveillant findById(@PathVariable int id) {
		return surveillantService.findById(id);
	}

	@PutMapping("/update")
	public Surveillant update(@RequestBody Surveillant p) {
		return surveillantService.update(p);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		surveillantService.delete(id);
	}

	
}

