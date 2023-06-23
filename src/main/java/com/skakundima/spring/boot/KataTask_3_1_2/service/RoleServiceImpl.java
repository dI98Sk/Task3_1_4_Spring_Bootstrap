package com.skakundima.spring.boot.KataTask_3_1_2.service;

import com.skakundima.spring.boot.KataTask_3_1_2.model.Role;
import com.skakundima.spring.boot.KataTask_3_1_2.repository.RoleRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{

    RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role add(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

}
