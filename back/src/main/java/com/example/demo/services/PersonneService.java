package com.example.demo.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.Personne;
import com.example.demo.entities.Role;
import com.example.demo.iservice.IRoleService;
import com.example.demo.iservice.IUserService;
import com.example.demo.repositories.PersonneRepository;




@Service


public class PersonneService implements IUserService {
 
	@Autowired
    private PersonneRepository userDao;

    @Autowired
    private IRoleService roleService;
    
     PasswordEncoder bCryptPasswordEncoder ;

   
    public List<Personne> findAll() {
        return userDao.findAll();
    }

   
    public Personne findByUsername(String username) {
        if (username == null)
        return null;
        return userDao.findUserByUsername(username);
    }

   
    public Personne findByUsernameWithRoles(String username) {
        if (username == null)
        return null;
        return userDao.findUserByUsername(username);
    }

   
    @Transactional
    public int deleteByUsername(String username) {
        return userDao.deleteByUsername(username);
    }

   
    public Personne findById(Long id) {
    	  if (id == null)
    	        return null;
    	        return userDao.getOne(id);
    }

    @Transactional
    public void deleteById(Long id) {
        userDao.deleteById(id);
    }

   
    public Personne save(Personne user) {
    	Personne foundedUserByUsername = findByUsername(user.getUsername());
    	Personne foundedUserByEmail = userDao.findByEmail(user.getEmail());
        if (foundedUserByUsername != null || foundedUserByEmail != null) return null;
        else {
            if (user.getPassword() == null || user.getPassword().isEmpty()) {
                user.setPassword((user.getUsername()));
            }
            user.setPassword(bCryptPasswordEncoder.encode("123"));

            user.setAccountNonExpired(true);
            user.setAccountNonLocked(true);
            user.setCredentialsNonExpired(true);
            user.setEnabled(true);
            user.setPasswordChanged(false);
            user.setCreatedAt(new Date());

            if (user.getRoles() != null) {
                Collection<Role> roles = new ArrayList<Role>();
                for (Role role : user.getRoles()) {
                    roles.add(roleService.save(role));
                }
                user.setRoles(roles);
            }
            Personne mySaved = userDao.save(user);

            return mySaved;
        }
    }

   
    public Personne update(Personne user) {
    	Personne foundedUser = findById(user.getId());
        if (foundedUser == null) return null;
        else {
            foundedUser.setEmail(user.getEmail());
            foundedUser.setUsername(user.getUsername());
            foundedUser.setPrenom(user.getPrenom());
            foundedUser.setNom(user.getNom());
            foundedUser.setEnabled(user.isEnabled());
            foundedUser.setCredentialsNonExpired(user.isCredentialsNonExpired());
            foundedUser.setAccountNonLocked(user.isAccountNonLocked());
            foundedUser.setAccountNonExpired(user.isAccountNonExpired());
            foundedUser.setAuthorities(new ArrayList<>());
            Collection<Role> roles = new ArrayList<Role>();
            for (Role role : user.getRoles()) {
            	roles.add(roleService.save(role));
            }
            foundedUser.setRoles(roles);
            return userDao.save(foundedUser);
        }
    }

   
    @Transactional
    public int delete(Long id) {
    	Personne foundedUser = findById(id);
        if (foundedUser == null) return -1;
        userDao.delete(foundedUser);
        return 1;
    }

   
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return findByUsernameWithRoles(username);
    }
	 

	
	

	
	
}
