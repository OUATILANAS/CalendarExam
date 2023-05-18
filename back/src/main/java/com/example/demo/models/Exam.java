package com.example.demo.models;

import javax.persistence.*;

import java.util.Calendar;

import java.util.Date;

@Entity
public class Exam {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private int duree;

	private Date dateTime;

	@ManyToOne
	@JoinColumn(name = "filiere_id")
	private Filiere filiere;

	@ManyToOne
	@JoinColumn(name = "salle_id")
	private Salle salle;

//getters setters
	public Exam(Long id, String nom, int duree, Date dateTime, Filiere filiere, Salle salle) {
		super();
		this.id = id;
		this.nom = nom;
		this.duree = duree;
		this.dateTime = dateTime;
		this.filiere = filiere;
		this.salle = salle;
	}

	public Exam() {
		// TODO Auto-generated constructor stub
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {

		Calendar cal = Calendar.getInstance();
		cal.setTime(dateTime);
		cal.set(Calendar.HOUR_OF_DAY, duree);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		dateTime = cal.getTime();
		this.dateTime = dateTime;

	}

	public Filiere getFiliere() {
		return filiere;
	}

	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

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

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

}
