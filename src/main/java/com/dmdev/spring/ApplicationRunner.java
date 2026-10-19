package com.dmdev.spring;

import com.dmdev.spring.config.ApplicationConfiguration;
import com.dmdev.spring.database.pool.ConnectionPool;
import com.dmdev.spring.database.repository.CrudRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationRunner {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class)) {
            ConnectionPool connectionPool = context.getBean("pool1", ConnectionPool.class);
            System.out.println(connectionPool);
            CrudRepository companyRepository = context.getBean("companyRepository", CrudRepository.class);
            System.out.println(companyRepository.findById(1));
        }
    }
}