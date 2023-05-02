package com.example.demo.controllers;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entities.Role;
import com.example.demo.services.RoleService;

@RequestMapping("/api/roles")
@RestController
// @PreAuthorize("hasRole(AuthoritiesConstants.super_admin)")
public class RoleController {
	 @Autowired
	    private RoleService roleService;

	    // @PreAuthorize("hasRole(AuthoritiesConstants.super_admin)")
	    @GetMapping("/")
	    public List<Role> findAll(){
	        return this.roleService.findAll();
	    }

}
