package com.example.demo.iservice;

import java.util.List;

import com.example.demo.entities.Role;

public interface IRoleService {
	 List<Role> findAll();

	    Role findByAuthority(String authority);

	    Role findById(Long id);

	    void deleteById(Long id);

	    Role save(Role role);

	    List<Role> create(List<Role> roles);

	    public Role update(Role role);

	    int delete(Role role);

	    int deleteByAuthority(String authority);

	    List<Role> findByUserName(String username);

}
