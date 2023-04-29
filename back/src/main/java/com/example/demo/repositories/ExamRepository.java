package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Calendar;
import com.example.demo.entities.Exam;

public interface ExamRepository extends JpaRepository<Exam, Integer>{
	Exam findById(int id);
	List<Exam> findExamsByCalendar(Calendar calendar);
}
