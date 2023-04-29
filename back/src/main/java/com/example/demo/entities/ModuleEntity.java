package com.example.demo.entities;

import java.util.ArrayList;
import java.util.Collection;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class ModuleEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
  	
  	private String nom;
  	
  	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	  @JoinColumn(name = "exam_id", nullable = false)
	  @OnDelete(action = OnDeleteAction.CASCADE)
	  @JsonIgnore
	  private Exam exam;
  	
  	
  	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	  @JoinColumn(name = "semester_id", nullable = false)
	  @OnDelete(action = OnDeleteAction.CASCADE)
	  @JsonIgnore
	  private Semester semester;
  	
  	@ManyToMany(mappedBy = "modules", fetch= FetchType.EAGER)
  	private Collection<Enseignant> enseignants = new ArrayList<>();

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

}
