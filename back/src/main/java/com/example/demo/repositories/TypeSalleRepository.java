package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.entities.TypeSalle;

public interface TypeSalleRepository extends JpaRepository<TypeSalle, Integer>{
	
	TypeSalle findById(int id);
}