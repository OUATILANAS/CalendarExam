package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Salle;
import com.example.demo.models.TypeSalle;

public interface SalleRepository extends JpaRepository<Salle, Integer>{
	
	Salle findById(int id);

	List<Salle> findByNom(TypeSalle nom);
}
