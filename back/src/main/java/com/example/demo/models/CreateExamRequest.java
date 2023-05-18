package com.example.demo.models;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateExamRequest {
	private String nom;
	private int duree;
	private Date dateTime;
	private int filiereId;
	private int salleId;
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	public int getFiliereId() {
		return filiereId;
	}
	public void setFiliereId(int filiereId) {
		this.filiereId = filiereId;
	}
	public int getSalleId() {
		return salleId;
	}
	public void setSalleId(int salleId) {
		this.salleId = salleId;
	}

	
	// Constructors, getters, and setters
}
