package com.micronautbook.data;

import io.micronaut.data.jdbc.runtime.JdbcOperations;
import io.micronaut.transaction.annotation.Transactional;
import jakarta.inject.Singleton;

import java.util.List;

@Singleton
public class MicronautBookRepository extends BookRepository {
    public MicronautBookRepository(JdbcOperations jdbcOperations) {
        super(jdbcOperations);
    }

    @Transactional
    @Override
    public List<Book> findAll() {
        return super.findAll();
    }
}
