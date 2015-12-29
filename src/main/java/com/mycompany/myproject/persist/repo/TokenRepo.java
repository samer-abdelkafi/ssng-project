package com.mycompany.myproject.persist.repo;

import com.mycompany.myproject.persist.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by b002ihq on 12/11/2015.
 */
public interface TokenRepo extends JpaRepository<Token, String> {
}
