package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IDao;
import com.example.demo.entities.ModuleEntity;
import com.example.demo.repositories.ModuleRepository;
@Service
public class ModuleService implements IDao<ModuleEntity>{
	@Autowired
    private ModuleRepository moduleRepository;

	@Override
	public ModuleEntity save(ModuleEntity p) {
		return moduleRepository.save(p);
	}

	@Override
	public List<ModuleEntity> findAll() {
		 return moduleRepository.findAll();
	}

	@Override
	public ModuleEntity findById(int id) {
		return moduleRepository.findById(id);
	}

	@Override
	public ModuleEntity update(ModuleEntity p) {
		return moduleRepository.save(p);
	}

	@Override
	public void delete(int id) {
		moduleRepository.deleteById(id);
		
	}

	
	
}

