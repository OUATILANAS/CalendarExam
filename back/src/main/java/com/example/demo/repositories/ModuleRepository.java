package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.ModuleEntity;



public interface ModuleRepository extends JpaRepository<ModuleEntity, Integer>{
	
	ModuleEntity findById(int id);
}