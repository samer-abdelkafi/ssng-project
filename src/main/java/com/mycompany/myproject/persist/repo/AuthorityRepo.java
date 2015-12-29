package com.mycompany.myproject.persist.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycompany.myproject.persist.entity.Authority;

public interface AuthorityRepo extends JpaRepository<Authority, Long> {

}