package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.entities.Personne;
import com.example.demo.entities.Role;

public interface PersonneRepository extends JpaRepository<Personne, Integer>{
	List<Personne> findByRole(Role role);
	
}
