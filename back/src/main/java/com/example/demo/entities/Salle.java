package com.example.demo.entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
