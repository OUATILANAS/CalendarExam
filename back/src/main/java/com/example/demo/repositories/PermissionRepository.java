package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Permission;

public interface PermissionRepository extends JpaRepository<Permission, Long>{
	public Permission findByName(String name);

}
