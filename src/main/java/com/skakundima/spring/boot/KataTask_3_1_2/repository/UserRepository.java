package com.skakundima.spring.boot.KataTask_3_1_2.repository;

import com.skakundima.spring.boot.KataTask_3_1_2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u join fetch u.roles where u.email = :firstName")
    Optional<User> findUserAndFetchRoles(String firstName);

}
