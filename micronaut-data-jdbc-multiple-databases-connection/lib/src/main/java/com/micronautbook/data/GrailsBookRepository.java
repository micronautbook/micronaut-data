package com.micronautbook.data;

import io.micronaut.transaction.annotation.Transactional;
import jakarta.inject.Named;
import jakarta.inject.Singleton;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Singleton
public class GrailsBookRepository extends BookRepository {
    public GrailsBookRepository(@Named("grails") Connection connection) {
        super(connection);
    }

    @Transactional("grails")
    @Override
    public List<Book> findAll() throws SQLException {
        return super.findAll();
    }
}
