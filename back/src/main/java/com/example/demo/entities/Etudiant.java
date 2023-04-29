package com.example.demo.entities;

import java.util.Collection;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;


@Entity
public class Etudiant extends Personne{
	

	
	private String matricule;
	
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	  @JoinColumn(name = "filiere_id", nullable = false)
	  @OnDelete(action = OnDeleteAction.CASCADE)
	  @JsonIgnore
	  private Filiere filiere;
	
	@OneToMany(mappedBy = "etudiant")
	private Collection<PasserExam> passerExams;
	
	
	  	

		public Etudiant() {
		super();
	}

		public String getMatricule() {
			return matricule;
		}

		public void setMatricule(String matricule) {
			this.matricule = matricule;
		}

		

		public Filiere getFiliere() {
			return filiere;
		}

		public void setFiliere(Filiere filiere) {
			this.filiere = filiere;
		}

		
		

	  	
}
