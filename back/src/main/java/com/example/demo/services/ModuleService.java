package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IDao;
import com.example.demo.models.ModuleEntity;
import com.example.demo.repository.ModuleRepository;
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
	public void update(ModuleEntity p) {
		 moduleRepository.save(p);
	}

	@Override
	public void delete(ModuleEntity p) {
		moduleRepository.delete(p);
		
	}

	
	
}

