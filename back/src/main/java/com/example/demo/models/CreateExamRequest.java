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

	// Constructors, getters, and setters
}
