package com.skakundima.spring.boot.KataTask_3_1_2.service;



import com.skakundima.spring.boot.KataTask_3_1_2.model.Role;

import java.util.List;

public interface RoleService {

    Role add(Role role);
    List<Role> findAll();
}
