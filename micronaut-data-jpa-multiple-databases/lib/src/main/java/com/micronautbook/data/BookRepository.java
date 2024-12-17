package com.micronautbook.data;

import io.micronaut.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
