package com.example.demo.entities;




import jakarta.persistence.*;

@Entity
public class Surveillant extends Personne{
	


	private String matricule;
	
	  

		public Surveillant() {
		super();
	}

		public String getMatricule() {
			return matricule;
		}

		public void setMatricule(String matricule) {
			this.matricule = matricule;
		}

		

	  	
}
