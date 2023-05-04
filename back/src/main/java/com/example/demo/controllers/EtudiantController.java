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

import com.example.demo.models.Etudiant;
import com.example.demo.models.Filiere;
import com.example.demo.services.EtudiantService;

@RestController
@RequestMapping("api/etudiants")
public class EtudiantController {
	
	@Autowired
	EtudiantService etudiantService;
	
	@GetMapping("/all")
	public List<Etudiant> findAll() {
		return etudiantService.findAll();
	}

	@GetMapping("/id/{id}")
	public Etudiant findById(@PathVariable int id) {
		return etudiantService.findById(id);
	}

	@PostMapping("/save")
	public Etudiant save(@RequestBody Etudiant p) {
		return etudiantService.save(p);
	}

	@PutMapping("/update")
	public Etudiant update(@RequestBody Etudiant p) {
		return etudiantService.update(p);
	}

	@GetMapping("/matriculte/{matricule}")
	public Etudiant findByMatricule(@PathVariable String matricule) {
		return etudiantService.findByMatricule(matricule);
	}

	@DeleteMapping("/delete/id/{id}")
	public void delete(@PathVariable int id) {
		etudiantService.delete(id);
	}
	
	@GetMapping("/filiere")
	public List<Etudiant> findEtudiantsByFiliere(@RequestBody Filiere filiere) {
		return etudiantService.findEtudiantsByFiliere(filiere);
	}

	
}
