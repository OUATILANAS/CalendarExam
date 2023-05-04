package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Surveillant;

public interface SurveillantRepository extends JpaRepository<Surveillant, Integer>{
	
	Surveillant findById(int id);
	Surveillant findByMatricule(String matricule);
	
}