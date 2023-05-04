/**
 * 
 */
package com.example.demo.repository;



import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.models.Filiere;

/**
 * @author ZINEB
 *
 */
public interface FiliereRepository extends JpaRepository<Filiere, Integer>{
	Filiere findById(int id);
	
}
