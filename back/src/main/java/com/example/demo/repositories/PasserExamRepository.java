package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Exam;
import com.example.demo.entities.PasserExam;

public interface PasserExamRepository extends JpaRepository<PasserExam, Integer>{
	
	List<PasserExam> findByExam(Exam exam);
	PasserExam findById(int id);
}
