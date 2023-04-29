package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Semester;

public interface SemesterRepository extends JpaRepository<Semester, Integer>{
	
	Semester findById(int id);
}
