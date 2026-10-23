package com.dmdev.spring.config;

import com.dmdev.spring.database.pool.ConnectionPool;
import com.dmdev.spring.database.repository.UserRepository;
import com.dmdev.web.config.WebConfiguration;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

@Configuration(proxyBeanMethods = true)
@PropertySource(value = "classpath:application.properties")
@ComponentScan(basePackages = "com.dmdev.spring", useDefaultFilters = true)
@Import(WebConfiguration.class)
public class ApplicationConfiguration {

    @Bean(value = "pool2")
    @Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public ConnectionPool pool(@Value("${db.username}") String username) {
        return new ConnectionPool(username, 10);
    }

    @Bean(value = "pool3")
    public ConnectionPool pool3() {
        return new ConnectionPool("test-poool", 15);
    }

    @Bean(value = "userRepository2")
    @Profile("prod|web")
    public UserRepository userRepository(@Qualifier("pool2") ConnectionPool connectionPool) {
        return new UserRepository(connectionPool);
    }

    @Bean
    public UserRepository userRepository3() {
        ConnectionPool connectionPool1 = pool3();
        ConnectionPool connectionPool2 = pool3();
        ConnectionPool connectionPool3 = pool3();
        return new UserRepository(pool3());
    }
}