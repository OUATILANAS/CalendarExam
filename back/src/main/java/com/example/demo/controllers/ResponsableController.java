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

import com.example.demo.models.Responsable;
import com.example.demo.services.ResponsableService;

@RestController
@RequestMapping("api/responsables")
public class ResponsableController {

	
	@Autowired
	ResponsableService responsableService;

	@GetMapping("/matricule/{matricule}")
	public Responsable findByMatricule(@PathVariable String matricule) {
		return responsableService.findByMatricule(matricule);
	}

	@PostMapping("/save")
	public Responsable save(@RequestBody Responsable p) {
		return responsableService.save(p);
	}

	@GetMapping("/all")
	public List<Responsable> findAll() {
		return responsableService.findAll();
	}

	@GetMapping("/id/{id}")
	public Responsable findById(@PathVariable int id) {
		return responsableService.findById(id);
	}

	@PutMapping("/update")
	public Responsable update(@RequestBody Responsable p) {
		return responsableService.update(p);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		responsableService.delete(id);
	}
	
	
}
