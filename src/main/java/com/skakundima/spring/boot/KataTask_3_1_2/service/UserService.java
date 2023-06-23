package com.skakundima.spring.boot.KataTask_3_1_2.service;

import com.skakundima.spring.boot.KataTask_3_1_2.model.User;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public interface UserService {

    User add(User user);
    void update(User user);
    void removeById(Long id);
    List<User> findAll();
    User findById(Long id);
}
