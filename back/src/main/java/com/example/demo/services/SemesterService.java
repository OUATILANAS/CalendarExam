package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IDao;
import com.example.demo.models.Semester;
import com.example.demo.repository.SemesterRepository;
@Service
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
	public void update(Semester p) {
		 semesterRepository.save(p);
	}

	@Override
	public void delete(Semester p) {
		semesterRepository.delete(p);
		
	}
}
