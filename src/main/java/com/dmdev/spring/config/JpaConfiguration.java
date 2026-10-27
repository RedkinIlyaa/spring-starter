package com.dmdev.spring.config;

import com.dmdev.spring.config.condition.JpaCondition;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Conditional(JpaCondition.class)
@Configuration
public class JpaConfiguration {

//    @Bean(name = "dbProperties1")
//    @ConfigurationProperties(
//            prefix = "db"
//    )
//    public DatabaseProperties dataBaseProperties() {
//        return new DatabaseProperties();
//    }

    @PostConstruct
    void init() {
        log.info("Jpa configuration is enabled");
    }
}
