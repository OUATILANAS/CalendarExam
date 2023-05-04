package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Exam;
import com.example.demo.models.PasserExam;

public interface PasserExamRepository extends JpaRepository<PasserExam, Integer>{
	
	List<PasserExam> findByExam(Exam exam);
	PasserExam findById(int id);
}
