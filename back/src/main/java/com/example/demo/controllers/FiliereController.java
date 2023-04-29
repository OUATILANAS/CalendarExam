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

import com.example.demo.entities.Filiere;
import com.example.demo.services.FiliereService;

@RestController
@RequestMapping("api/filieres")
public class FiliereController {

	@Autowired
	FiliereService filiereService;
	

	@PostMapping("/save")
	public Filiere save(@RequestBody Filiere p) {
		return filiereService.save(p);
	}

	@GetMapping("/all")
	public List<Filiere> findAll() {
		return filiereService.findAll();
	}

	@GetMapping("/id/{id}")
	public Filiere findById(@PathVariable int id) {
		return filiereService.findById(id);
	}

	@PutMapping("/update")
	public Filiere update(@RequestBody Filiere p) {
		return filiereService.update(p);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		filiereService.delete(id);
	}
	
	
}
