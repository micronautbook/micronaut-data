package com.micronautbook.data;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller("/books")
class BookController {
    private final MicronautBookRepository micronautBookRepository;
    private final GrailsBookRepository grailsBookRepository;

    BookController(MicronautBookRepository micronautBookRepository,
                   GrailsBookRepository grailsBookRepository) {
        this.micronautBookRepository = micronautBookRepository;
        this.grailsBookRepository = grailsBookRepository;
    }

    @Get
    List<Book> all() throws SQLException {
        List<Book> all = new ArrayList<>();
        all.addAll(micronaut());
        all.addAll(grails());
        return all;
    }

    @Get("/micronaut")
    List<Book> micronaut() throws SQLException {
        return micronautBookRepository.findAll();
    }

    @Get("/grails")
    List<Book> grails() throws SQLException {
        return grailsBookRepository.findAll();
    }
}
