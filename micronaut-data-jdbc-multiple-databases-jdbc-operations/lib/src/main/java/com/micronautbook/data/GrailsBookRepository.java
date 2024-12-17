package com.micronautbook.data;

import io.micronaut.data.jdbc.runtime.JdbcOperations;
import io.micronaut.transaction.annotation.Transactional;
import jakarta.inject.Named;
import jakarta.inject.Singleton;

import java.util.List;

@Singleton
public class GrailsBookRepository extends BookRepository {
    public GrailsBookRepository(@Named("grails") JdbcOperations jdbcOperations) {
        super(jdbcOperations);
    }

    @Transactional("grails")
    @Override
    public List<Book> findAll() {
        return super.findAll();
    }
}
