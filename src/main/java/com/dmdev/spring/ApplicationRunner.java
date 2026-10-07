package com.dmdev.spring;

import com.dmdev.spring.database.pool.ConnectionPool;
import com.dmdev.spring.database.repository.CompanyRepository;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationRunner {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("application.xml");
        ConnectionPool connectionPool = classPathXmlApplicationContext.getBean("pool1", ConnectionPool.class);
        System.out.println(connectionPool);
        CompanyRepository companyRepository = classPathXmlApplicationContext.getBean("companyRepository", CompanyRepository.class);
        System.out.println(companyRepository);
    }
}
