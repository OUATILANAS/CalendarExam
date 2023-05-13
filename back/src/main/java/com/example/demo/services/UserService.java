package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.example.demo.dao.IDao;
import com.example.demo.models.User;
import com.example.demo.repository.UserRepository;


@Service
public class UserService implements IDao<User>{
	
	
	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User save(User o) {
		return null;
	}


	@Override
	public void update(User o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(User o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	 
		
	

}
