package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	 Role findByName(String name);
	 Role findById(long id);
	 Role findByAuthority(String authority);
	    int deleteByAuthority(String authority);
	    List<Role> findAllByUsersUsername(String username);

}
