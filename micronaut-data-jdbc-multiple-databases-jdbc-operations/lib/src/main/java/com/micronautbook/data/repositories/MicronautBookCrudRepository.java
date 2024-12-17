package com.micronautbook.data.repositories;

import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;

@JdbcRepository(dialect = Dialect.H2)
public interface MicronautBookCrudRepository extends BookCrudRepository {
}
