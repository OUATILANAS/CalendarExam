package com.example.demo.models;
import javax.persistence.*;
import java.util.Date;



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
