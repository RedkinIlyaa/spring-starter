package com.dmdev.spring.database.repository;

import com.dmdev.spring.database.pool.ConnectionPool;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class UserRepository {
    private final ConnectionPool connectionPool;

    public UserRepository(@Qualifier(value = "pool2") ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }
}
