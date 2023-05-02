package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dao.IDao;
import com.example.demo.entities.Semester;
import com.example.demo.repositories.SemesterRepository;

public class SemesterService implements IDao<Semester>{
	@Autowired
    private SemesterRepository semesterRepository;

	@Override
	public Semester save(Semester p) {
		return semesterRepository.save(p);
	}

	@Override
	public List<Semester> findAll() {
		 return semesterRepository.findAll();
	}

	@Override
	public Semester findById(int id) {
		return semesterRepository.findById(id);
	}

	@Override
	public Semester update(Semester p) {
		return semesterRepository.save(p);
	}

	@Override
	public void delete(int id) {
		semesterRepository.deleteById(id);
		
	}
}
