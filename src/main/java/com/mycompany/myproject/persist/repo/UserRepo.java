package com.mycompany.myproject.persist.repo;

import com.mycompany.myproject.persist.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepo extends JpaRepository<User, Long> {
    User findByLogin(String login);

}
