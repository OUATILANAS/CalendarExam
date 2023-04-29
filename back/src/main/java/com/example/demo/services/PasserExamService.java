package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Exam;
import com.example.demo.entities.PasserExam;
import com.example.demo.repositories.PasserExamRepository;

@Service
public class PasserExamService {
	@Autowired
    private PasserExamRepository passerExamRepository;

    
    public PasserExam savePasserExam(PasserExam passerExam) {
        return passerExamRepository.save(passerExam);
    }

   
    public List<PasserExam> getAllPasserExams() {
        return passerExamRepository.findAll();
    }

    
    public PasserExam getPasserExamById(int id) {
        return passerExamRepository.findById(id);
    }

    
    public void deletePasserExamById(int id) {
        passerExamRepository.deleteById(id);
    }

    
    public List<PasserExam> getPasserExamsByExam(Exam exam) {
        return passerExamRepository.findByExam(exam);
    }
}
