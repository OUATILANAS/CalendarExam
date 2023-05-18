package com.example.demo.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Exam;
import com.example.demo.models.Salle;

public interface ExamRepository extends JpaRepository<Exam, Integer> {
	Exam findById(int id);

	boolean existsByDateTimeAndSalle(Date dateTime, Salle salle);

}
