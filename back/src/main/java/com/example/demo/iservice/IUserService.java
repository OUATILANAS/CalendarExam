package com.example.demo.iservice;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.entities.Personne;

public interface IUserService extends UserDetailsService{
	List<Personne> findAll();

	Personne findByUsername(String username);

	Personne findById(Long id);

    void deleteById(Long id);

    Personne save(Personne user);

    Personne update(Personne user);

    int delete(Long id);

    Personne findByUsernameWithRoles(String username);

    int  deleteByUsername(String username);

    public UserDetails loadUserByUsername(String username);

}
