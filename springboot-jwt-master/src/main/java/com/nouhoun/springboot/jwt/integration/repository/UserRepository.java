package com.nouhoun.springboot.jwt.integration.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.nouhoun.springboot.jwt.integration.domain.User;


public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
