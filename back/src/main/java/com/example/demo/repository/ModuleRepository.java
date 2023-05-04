package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.ModuleEntity;



public interface ModuleRepository extends JpaRepository<ModuleEntity, Integer>{
	
	ModuleEntity findById(int id);
}