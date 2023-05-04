package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.models.TypeSalle;

public interface TypeSalleRepository extends JpaRepository<TypeSalle, Integer>{
	
	TypeSalle findById(int id);
}