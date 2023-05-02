package com.example.demo.services;

import com.example.demo.entities.Permission;
import com.example.demo.iservice.IPermissionService;
import com.example.demo.repositories.PermissionRepository;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class PermissionService implements IPermissionService{
	 @Autowired
	    private PermissionRepository permissionDao;

	@Override
	public Permission save(com.example.demo.entities.Permission permission) {
		Permission perm = permissionDao.findByName(permission.getName());
        return perm == null ? permissionDao.save(permission) : perm;
	}
	   

}
