package com.mycompany.myproject.persist.repo;

import com.mycompany.myproject.persist.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepo extends JpaRepository<Token, String> {
}
