package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IDAO;
import com.example.demo.models.Salle;
import com.example.demo.models.TypeSalle;
import com.example.demo.repository.SalleRepository;

@Service
public class SalleService implements IDAO<Salle>{
	@Autowired
    private SalleRepository salleRepository;
	

	@Override
	public Salle save(Salle p) {
		return salleRepository.save(p);
	}

	@Override
	public List<Salle> findAll() {
		 return salleRepository.findAll();
	}

	@Override
	public Salle findById(int id) {
		return salleRepository.findById(id);
	}

	
	@Override
	public void update(Salle p) {
		 salleRepository.save(p);
	}

	@Override
	public void delete(Salle p) {
		salleRepository.delete(p);
		
	}

	public List<Salle> findSalleByType(TypeSalle nom) {
        return salleRepository.findByNom(nom);
    }
	
	
	
}

