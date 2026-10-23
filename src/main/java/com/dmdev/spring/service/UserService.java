package com.dmdev.spring.service;

import com.dmdev.spring.database.entity.Company;
import com.dmdev.spring.database.repository.CrudRepository;
import com.dmdev.spring.database.repository.UserRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final CrudRepository<Integer, Company> crudRepository;

    public UserService(@Qualifier("userRepository") UserRepository userRepository, CrudRepository<Integer, Company> crudRepository) {
        this.userRepository = userRepository;
        this.crudRepository = crudRepository;
    }
}
