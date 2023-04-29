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

import com.example.demo.entities.Semester;
import com.example.demo.services.SemesterService;

@RestController
@RequestMapping("api/semestres")
public class SemestreController {

	
	@Autowired
	SemesterService semesterService;

	
	@PostMapping("/save")
	public Semester save(@RequestBody Semester p) {
		return semesterService.save(p);
	}

	@GetMapping("/all")
	public List<Semester> findAll() {
		return semesterService.findAll();
	}

	@GetMapping("/id/{id}")
	public Semester findById(@PathVariable int id) {
		return semesterService.findById(id);
	}

	@PutMapping("/update")
	public Semester update(@RequestBody Semester p) {
		return semesterService.update(p);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		semesterService.delete(id);
	}
	
	
}
