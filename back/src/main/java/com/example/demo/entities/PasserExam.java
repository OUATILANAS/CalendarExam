package com.example.demo.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class PasserExam {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Date dateExam;
	@ManyToOne 
	private Etudiant etudiant;
	@ManyToOne
	private Exam exam;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDateExam() {
		return dateExam;
	}
	public void setDateExam(Date dateExam) {
		this.dateExam = dateExam;
	}
	public Etudiant getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
	public Exam getExam() {
		return exam;
	}
	public void setExam(Exam exam) {
		this.exam = exam;
	}
	
	

}
