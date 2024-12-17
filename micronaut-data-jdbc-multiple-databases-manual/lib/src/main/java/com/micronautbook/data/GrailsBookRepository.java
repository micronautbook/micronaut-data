package com.micronautbook.data;

import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

@JdbcRepository(dialect = Dialect.H2, dataSource = "grails")
public interface GrailsBookRepository extends BookRepository {
}
