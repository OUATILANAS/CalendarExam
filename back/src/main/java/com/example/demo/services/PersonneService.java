package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.entities.Personne;
import com.example.demo.entities.Role;
import com.example.demo.repositories.PersonneRepository;
@Service
public class PersonneService {
	@Autowired
    private PersonneRepository personneRepository;
	
	public List<Personne> findPersonneByRole(Role role) {
        return personneRepository.findByRole(role);
    }
}
