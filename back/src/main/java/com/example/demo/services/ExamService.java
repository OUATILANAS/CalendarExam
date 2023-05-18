package com.example.demo.services;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Exam;
import com.example.demo.models.Filiere;
import com.example.demo.models.Salle;
import com.example.demo.repository.ExamRepository;
import com.example.demo.repository.FiliereRepository;
import com.example.demo.repository.SalleRepository;

@Service
public class ExamService {
	@Autowired
	private ExamRepository examRepository;
	@Autowired
	private FiliereRepository filiereRepository;
	@Autowired
	private SalleRepository salleRepository;

	public Exam save(Exam p) {
		return examRepository.save(p);
	}

	public Date addHoursToJavaUtilDate(Date date, int hours) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.HOUR_OF_DAY, hours);
		return calendar.getTime();
	}

	public Exam createExam(String nom, int duree, Date dateTime, int filiereId, int salleId) {
		Filiere filiere = filiereRepository.findById(filiereId);

		Salle salle = salleRepository.findById(salleId);
		Date dateTime2 = addHoursToJavaUtilDate(dateTime, duree - 1);
		System.out.println(dateTime2);
		if (examRepository.existsByDateTimeAndSalle(dateTime2, salle)) {
			throw new IllegalStateException("nope nope change");
		} else {
			System.out.println("yesssssssssss");

		}

		Exam exam = new Exam();
		exam.setNom(nom);
		exam.setDuree(duree);
		exam.setDateTime(dateTime);
		exam.setFiliere(filiere);
		exam.setSalle(salle);

		return examRepository.save(exam);
	}

	public List<Exam> findAll() {
		return examRepository.findAll();
	}

	public Exam findById(int id) {
		return examRepository.findById(id);
	}

	public Exam update(Exam p) {
		return examRepository.save(p);
	}

	public void delete(int id) {
		examRepository.deleteById(id);

	}

}
