package com.example.demo.entities;




import jakarta.persistence.*;


@Entity
public class Responsable extends Personne{
	


	private String matricule;
	

		public Responsable() {
		super();
	}

		public String getMatricule() {
			return matricule;
		}

		public void setMatricule(String matricule) {
			this.matricule = matricule;
		}

		

	  	
}
