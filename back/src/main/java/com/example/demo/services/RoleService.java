package com.example.demo.services;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.Permission;
import com.example.demo.entities.Role;
import com.example.demo.iservice.IPermissionService;
import com.example.demo.iservice.IRoleService;
import com.example.demo.repositories.RoleRepository;




@Service
public class RoleService implements IRoleService {
	@Autowired
    private RoleRepository roleDao;

    @Autowired
    private IPermissionService permissionService;

    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    @Override
    public Role findByAuthority(String authority) {
        if (authority == null) return null;
        return roleDao.findByAuthority(authority);
    }

    @Override
    @Transactional
    public int deleteByAuthority(String authority) {
        return roleDao.deleteByAuthority(authority);
    }

    @Override
    public Role findById(Long id) {
        if (id == null)
        return null;
        return roleDao.getOne(id);
    }

    @Transactional
    public void deleteById(Long id) {
        roleDao.deleteById(id);
    }

    @Override
    public List<Role> create(List<Role> roles) {
        List<Role>  resultat = new ArrayList<>();
        roles.forEach(r->resultat.add(save(r)));
        return resultat;
    }

    @Override
    public Role update(Role role) {
        Role foundedRole = findById(role.getId());
        if (foundedRole == null) return null;
        return roleDao.save(role);
    }

    @Override
    @Transactional
    public int delete(Role role) {
        if (role.getAuthority() == null) return -1;

        Role foundedRole = findByAuthority(role.getAuthority());
        if (foundedRole == null) return -1;
        roleDao.delete(foundedRole);
        return 1;
    }

    @Override
    public Role save(Role role) {
        Role r =  findByAuthority(role.getAuthority());
        if(r != null) return r;
        List<Permission> perms = new ArrayList<>();
        role.getPermissions().forEach(perm -> {
            perms.add(permissionService.save(perm));
        });
        role.setPermissions(perms);
        return roleDao.save(role);
    }

    @Override
    public List<Role> findByUserName(String username) {
        if(username == null) return null;
        return roleDao.findAllByUsersUsername(username);
    }


}
