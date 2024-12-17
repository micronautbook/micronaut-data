package com.micronautbook.data;

import io.micronaut.transaction.annotation.Transactional;
import jakarta.inject.Singleton;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Singleton
public class MicronautBookRepository extends BookRepository {
    public MicronautBookRepository(Connection connection) {
        super(connection);
    }

    @Transactional
    @Override
    public List<Book> findAll() throws SQLException {
        return super.findAll();
    }
}
