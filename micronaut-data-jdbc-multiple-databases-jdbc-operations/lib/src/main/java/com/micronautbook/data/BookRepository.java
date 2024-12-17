package com.micronautbook.data;

import io.micronaut.data.jdbc.runtime.JdbcOperations;

import java.sql.ResultSet;
import java.util.List;

public class BookRepository {

    private final JdbcOperations jdbcOperations;
    public BookRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    public List<Book> findAll() {
        String sql = "SELECT * FROM Book AS book";
        return jdbcOperations.prepareStatement(sql, statement -> {
            ResultSet resultSet = statement.executeQuery();
            return jdbcOperations.entityStream(resultSet, Book.class).toList();
        });
    }
}
