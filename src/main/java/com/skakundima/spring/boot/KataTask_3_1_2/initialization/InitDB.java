package com.skakundima.spring.boot.KataTask_3_1_2.initialization;

import com.skakundima.spring.boot.KataTask_3_1_2.model.Role;
import com.skakundima.spring.boot.KataTask_3_1_2.model.User;
import com.skakundima.spring.boot.KataTask_3_1_2.service.RoleService;
import com.skakundima.spring.boot.KataTask_3_1_2.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import javax.annotation.PostConstruct;

@Component
public class InitDB {

    private final RoleService roleService;
    private final UserService userService;

    public InitDB(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @PostConstruct
    @Transactional
    public void fillDb() {

        Role roleAdmin = new Role("ROLE_ADMIN");
        Role roleUser = new Role("ROLE_USER");

        User admin = new User( "Dmitrii", "Skakun", 25, "skakun@gmail.com", "111");
        admin.addRole(roleService.add(roleAdmin));
        userService.add(admin);

        User user = new User( "Georgiy", "Sidorov",25, "sidorov@gmail.com", "222");
        user.addRole(roleService.add(roleUser));
        userService.add(user);

        User userAdmin = new User( "Ilya", "Ivanov",26, "ivanov@gmail.com", "777");
        userAdmin.addRole(roleService.add(roleUser));
        userAdmin.addRole(roleService.add(roleAdmin));
        userService.add(userAdmin);
    }
}
