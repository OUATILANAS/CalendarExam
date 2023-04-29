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

import com.example.demo.entities.TypeSalle;
import com.example.demo.services.TypeSalleService;

@RestController
@RequestMapping("api/typesalles")
public class TypeSalleController {

	
	@Autowired
	TypeSalleService typeSalleService;

	@PostMapping("/save")
	public TypeSalle save(@RequestBody TypeSalle p) {
		return typeSalleService.save(p);
	}

	@GetMapping("/all")
	public List<TypeSalle> findAll() {
		return typeSalleService.findAll();
	}

	@GetMapping("/id/{id}")
	public TypeSalle findById(@PathVariable int id) {
		return typeSalleService.findById(id);
	}

	@PutMapping("/update")
	public TypeSalle update(@RequestBody TypeSalle p) {
		return typeSalleService.update(p);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		typeSalleService.delete(id);
	}
	
	
}
