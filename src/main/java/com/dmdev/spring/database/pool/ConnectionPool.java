package com.dmdev.spring.database.pool;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Slf4j
@Component(value = "pool1")
@RequiredArgsConstructor
public class ConnectionPool {
    @Value("${db.username}")
    public final String username;
    @Value("${db.pool.size}")
    private final Integer poolSize;

    @PostConstruct
    private void init() {
        log.info("Init connection pool in @PostConstruct");
    }

    @PreDestroy
    private void destroy() {
        log.info("Clean connection pool");
    }
}