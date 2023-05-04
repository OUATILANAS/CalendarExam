package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Exam;
import com.example.demo.models.PasserExam;
import com.example.demo.services.PasserExamService;

@RestController
@RequestMapping("api/passerexams")
public class PasserExamController {

	@Autowired
	PasserExamService passerExamService;

	@PostMapping("/save")
	public PasserExam savePasserExam(@RequestBody PasserExam passerExam) {
		return passerExamService.savePasserExam(passerExam);
	}

	@GetMapping("/all")
	public List<PasserExam> getAllPasserExams() {
		return passerExamService.getAllPasserExams();
	}

	@GetMapping("/id/{id}")
	public PasserExam getPasserExamById(@PathVariable int id) {
		return passerExamService.getPasserExamById(id);
	}

	@DeleteMapping("/delete/{id}")
	public void deletePasserExamById(@PathVariable int id) {
		passerExamService.deletePasserExamById(id);
	}

	@GetMapping("/all/exam")
	public List<PasserExam> getPasserExamsByExam(@RequestBody Exam exam) {
		return passerExamService.getPasserExamsByExam(exam);
	}
	
	
	
}
