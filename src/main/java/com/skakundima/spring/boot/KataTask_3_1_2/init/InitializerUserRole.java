package com.skakundima.spring.boot.KataTask_3_1_2.init;

import com.skakundima.spring.boot.KataTask_3_1_2.entity.Role;
import com.skakundima.spring.boot.KataTask_3_1_2.entity.User;
import com.skakundima.spring.boot.KataTask_3_1_2.repository.RoleRepository;
import com.skakundima.spring.boot.KataTask_3_1_2.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;


import java.util.Set;



@Configuration
public class InitializerUserRole {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    public InitializerUserRole(UserRepository userRepository,
                               RoleRepository roleRepository,
                               PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    @Transactional
    public void init() {
        Role adminRole = new Role("ADMIN");
        Role userRole = new Role("USER");

        roleRepository.save(adminRole);
        roleRepository.save(userRole);

        User admin = new User("admin","admin", "admin@mail.ru",
                passwordEncoder.encode("100"),30);
        admin.setRoles(Set.of(adminRole, userRole));
        userRepository.save(admin);

        User user = new User("user", "user", "user@mail.ru",
                passwordEncoder.encode("100"), 30);
        user.setRoles(Set.of(userRole));
        userRepository.save(user);
    }
}


