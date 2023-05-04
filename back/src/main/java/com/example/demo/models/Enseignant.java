package com.example.demo.models;
import javax.persistence.*;


import java.util.ArrayList;
import java.util.Collection;





@Entity
public class Enseignant extends Personne{
	

	
	private String matricule;
	
	
	@ManyToMany(fetch= FetchType.EAGER)
  	private Collection<ModuleEntity> modules = new ArrayList<>();
	
	  	

		

		public String getMatricule() {
			return matricule;
		}

		public void setMatricule(String matricule) {
			this.matricule = matricule;
		}

		

	  	
}
