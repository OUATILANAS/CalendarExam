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
public class Salle {
	
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
		
		private String nom;
		private int capacite;
		
		@ManyToOne(fetch = FetchType.LAZY, optional = false)
		  @JoinColumn(name = "typesalle_id", nullable = false)
		  @OnDelete(action = OnDeleteAction.CASCADE)
		  @JsonIgnore
		  private TypeSalle typesalle;
		

		@ManyToOne(fetch = FetchType.LAZY, optional = false)
		  @JoinColumn(name = "exam_id", nullable = false)
		  @OnDelete(action = OnDeleteAction.CASCADE)
		  @JsonIgnore
		  private Exam exam;


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

		public int getCapacite() {
			return capacite;
		}

		public void setCapacite(int capacite) {
			this.capacite = capacite;
		}

		public TypeSalle getTypesalle() {
			return typesalle;
		}

		public void setTypesalle(TypeSalle typesalle) {
			this.typesalle = typesalle;
		}

		public Exam getExam() {
			return exam;
		}

		public void setExam(Exam exam) {
			this.exam = exam;
		}
		
		

}
