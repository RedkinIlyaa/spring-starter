package com.dmdev.spring.database.pool;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component(value = "pool1")
public class ConnectionPool {
    public final String username;
    private final Integer poolSize;

    @Autowired
    public ConnectionPool(@Value("${db.username}") String username,
                           @Value("${db.pool.size}") Integer poolSize) {
        this.username = username;
        this.poolSize = poolSize;
    }

    @PostConstruct
    private void init() {
        System.out.println("Init connection pool in @PostConstruct");
    }

    @PreDestroy
    private void destroy() {
        System.out.println("Clean connection pool");
    }
}