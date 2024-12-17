package com.micronautbook.data.repositories;

import com.micronautbook.data.Book;
import io.micronaut.data.repository.CrudRepository;

public interface BookCrudRepository extends CrudRepository<Book, Long> {
}
