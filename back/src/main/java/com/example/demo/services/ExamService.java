package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.models.Calendar;
import com.example.demo.models.Exam;
import com.example.demo.repository.ExamRepository;

@Service
public class ExamService {
	@Autowired
    private ExamRepository examRepository;

	
	public Exam save(Exam p) {
		return examRepository.save(p);
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
	
	
	public List<Exam> findExamsByCalendar(Calendar calendar) {
        return examRepository.findExamsByCalendar(calendar);
    }

	
}
