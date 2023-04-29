package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Salle;
import com.example.demo.entities.TypeSalle;

public interface SalleRepository extends JpaRepository<Salle, Integer>{
	
	Salle findById(int id);

	List<Salle> findByNom(TypeSalle nom);
}
