package com.micronautbook.data.repositories;

import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;

@JdbcRepository(dialect = Dialect.H2, dataSource = "grails")
public interface GrailsBookCrudRepository extends BookCrudRepository {
}
