package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Surveillant;
import com.example.demo.repository.SurveillantRepository;
@Service
public class SurveillantService {
	@Autowired
    private SurveillantRepository surveillantRepository;

	
	public Surveillant findByMatricule(String matricule) {
		return surveillantRepository.findByMatricule(matricule);
	}


	public Surveillant save(Surveillant p) {
		return surveillantRepository.save(p);
	}



	public List<Surveillant> findAll() {
		return surveillantRepository.findAll();
	}


	
	public Surveillant findById(int id) {
		return surveillantRepository.findById(id);
	}


	
	public Surveillant update(Surveillant p) {
		return surveillantRepository.save(p);
	}


	
	public void delete(int id) {
		surveillantRepository.deleteById(id);
		
	}

}
