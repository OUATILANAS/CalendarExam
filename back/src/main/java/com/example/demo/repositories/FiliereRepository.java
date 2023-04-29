/**
 * 
 */
package com.example.demo.repositories;



import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.entities.Filiere;

/**
 * @author ZINEB
 *
 */
public interface FiliereRepository extends JpaRepository<Filiere, Integer>{
	Filiere findById(int id);
	
}
