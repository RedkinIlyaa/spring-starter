package com.dmdev.spring.database.repository;

import com.dmdev.spring.bpp.Auditing;
import com.dmdev.spring.bpp.Transaction;
import com.dmdev.spring.database.entity.Company;
import com.dmdev.spring.database.pool.ConnectionPool;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
@Repository
@Auditing
@Transaction
public class CompanyRepository implements CrudRepository<Integer, Company> {

    private final ConnectionPool pool;
    private final List<ConnectionPool> pools;
    private final Integer poolsize;

    public CompanyRepository(@Qualifier(value = "pool2") ConnectionPool pool,
                             @Value(value = "#{${db.pool.size}}") Integer poolsize,
                             List<ConnectionPool> pools) {
        this.pool = pool;
        this.poolsize = poolsize;
        this.pools = pools;
    }

    @PostConstruct
    private void init() {
        System.out.println("init company repository");
    }

    @Override
    public Optional<Company> findById(Integer id) {
        System.out.println("findById method...");
        return Optional.of(new Company(id));
    }

    @Override
    public void delete(Company entity) {
        System.out.println("delete method...");
    }
}