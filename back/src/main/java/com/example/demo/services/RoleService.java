package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dao.IDao;
import com.example.demo.entities.Role;
import com.example.demo.repositories.RoleRepository;

@Service
public class RoleService implements IDao<Role>{

	@Autowired
    private RoleRepository roleRepository;

	@Override
	public Role save(Role p) {
		return roleRepository.save(p);
	}

	@Override
	public List<Role> findAll() {
		 return roleRepository.findAll();
	}

	@Override
	public Role findById(int id) {
		return roleRepository.findById(id).get();
	}

	@Override
	public Role update(Role p) {
		return roleRepository.save(p);
	}
	@Override
	public void delete(int id) {
		roleRepository.deleteById(id);	
	}
}
