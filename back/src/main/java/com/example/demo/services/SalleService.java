package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dao.IDao;
import com.example.demo.entities.Salle;
import com.example.demo.entities.TypeSalle;
import com.example.demo.repositories.SalleRepository;


public class SalleService implements IDao<Salle>{
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
	public Salle update(Salle p) {
		return salleRepository.save(p);
	}

	@Override
	public void delete(int id) {
		salleRepository.deleteById(id);
		
	}

	public List<Salle> findSalleByType(TypeSalle nom) {
        return salleRepository.findByNom(nom);
    }
	
	
	
}

