package com.skakundima.spring.boot.KataTask_3_1_2.service;

import com.skakundima.spring.boot.KataTask_3_1_2.entity.Role;
import com.skakundima.spring.boot.KataTask_3_1_2.repository.RoleRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
}
