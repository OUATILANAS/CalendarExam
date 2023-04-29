package com.example.demo.entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Filiere {
	
	  	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	  	
	  	private String nom;
	  	private String code;
	  	
		@ManyToOne(fetch = FetchType.LAZY, optional = false)
		  @JoinColumn(name = "semester_id", nullable = false)
		  @OnDelete(action = OnDeleteAction.CASCADE)
		  @JsonIgnore
		  private Semester semester;
		
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getNom() {
			return nom;
		}
		public void setNom(String nom) {
			this.nom = nom;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public Semester getSemester() {
			return semester;
		}
		public void setSemester(Semester semester) {
			this.semester = semester;
		}
	  	
	  	

}
