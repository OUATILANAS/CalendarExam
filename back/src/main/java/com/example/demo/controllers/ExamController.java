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

import com.example.demo.entities.Calendar;
import com.example.demo.entities.Exam;
import com.example.demo.services.ExamService;

@RestController
@RequestMapping("api/exams")
public class ExamController {
	
	@Autowired
	ExamService examService;

	@PostMapping("/save")
	public Exam save(@RequestBody Exam p) {
		return examService.save(p);
	}

	@GetMapping("/all")
	public List<Exam> findAll() {
		return examService.findAll();
	}

	@GetMapping("/id/{id}")
	public Exam findById(@PathVariable int id) {
		return examService.findById(id);
	}

	@PutMapping("/update")
	public Exam update(@RequestBody Exam p) {
		return examService.update(p);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		examService.delete(id);
	}

	@GetMapping("/calendar")
	public List<Exam> findExamsByCalendar(@RequestBody Calendar calendar) {
		return examService.findExamsByCalendar(calendar);
	}

	
}
