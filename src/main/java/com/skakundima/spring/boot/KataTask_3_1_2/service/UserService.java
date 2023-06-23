package com.skakundima.spring.boot.KataTask_3_1_2.service;





import com.skakundima.spring.boot.KataTask_3_1_2.entity.User;

import java.util.List;

public interface UserService {

    List<User> getUsers();

    void deleteUserById(long id);

    void addUser(User user);

    void editUser(User user);
    User getUserById(long id);
    User getUserByEmail(String email);
}
