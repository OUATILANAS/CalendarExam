package com.example.demo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Etudiant;
import com.example.demo.models.Filiere;




public interface EtudiantRepository extends JpaRepository<Etudiant, Integer>{
	Etudiant findByMatricule(String matricule);
	Etudiant findById(int id);
	List<Etudiant> findByFiliere(Filiere filiere);
	
}


