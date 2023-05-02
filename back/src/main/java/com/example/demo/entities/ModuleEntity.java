package com.example.demo.entities;

import java.util.ArrayList;
import java.util.Collection;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

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
