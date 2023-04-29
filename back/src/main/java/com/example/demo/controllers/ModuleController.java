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

import com.example.demo.entities.ModuleEntity;
import com.example.demo.services.ModuleService;

@RestController
@RequestMapping("api/modules")
public class ModuleController {

	@Autowired
	ModuleService moduleService;

	
	@PostMapping("/save")
	public ModuleEntity save(@RequestBody ModuleEntity p) {
		return moduleService.save(p);
	}

	@GetMapping("/all")
	public List<ModuleEntity> findAll() {
		return moduleService.findAll();
	}

	@GetMapping("/id/{id}")
	public ModuleEntity findById(@PathVariable int id) {
		return moduleService.findById(id);
	}

	@PutMapping("/update")
	public ModuleEntity update(@RequestBody ModuleEntity p) {
		return moduleService.update(p);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		moduleService.delete(id);
	}
	
	
}
