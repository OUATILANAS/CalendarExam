package com.example.demo.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Filiere;




public interface EtudiantRepository extends JpaRepository<Etudiant, Integer>{
	Etudiant findByMatricule(String matricule);
	Etudiant findById(int id);
	List<Etudiant> findByFiliere(Filiere filiere);
	
}


