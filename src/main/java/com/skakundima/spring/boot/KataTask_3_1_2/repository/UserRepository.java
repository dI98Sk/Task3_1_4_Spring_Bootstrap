package com.skakundima.spring.boot.KataTask_3_1_2.repository;

import com.skakundima.spring.boot.KataTask_3_1_2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select u from User u left join fetch u.roles where u.email=:email")
    User findByEmail(String email);
    User getUserById(long id);
}
