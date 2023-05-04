package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Semester;

public interface SemesterRepository extends JpaRepository<Semester, Integer>{
	
	Semester findById(int id);
}
