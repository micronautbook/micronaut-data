package com.micronautbook.data;

import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.BlockingHttpClient;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest(transactional = false)
class BookControllerTest {

    @Inject
    MicronautBookRepository micronautBookRepository;

    @Inject
    GrailsBookRepository grailsBookRepository;

    @Inject
    @Client("/")
    HttpClient httpClient;

    @Test
    void books() {
        //given:
        saveGrailsBooks();
        saveMicronautBooks();

        BlockingHttpClient client = httpClient.toBlocking();
        Argument<List<Book>> arg = Argument.listOf(Book.class);

        //when:
        List<Book> books = client.retrieve(HttpRequest.GET("/books"), arg);
        //then:
        assertEquals(9, books.size());

        //when:
        books = client.retrieve(HttpRequest.GET("/books/micronaut"), arg);
        //then:
        assertEquals(2, books.size());

        //when:
        books = client.retrieve(HttpRequest.GET("/books/grails"), arg);

        //then:
        assertEquals(7, books.size());
        //cleanup:
        grailsBookRepository.deleteAll();
        micronautBookRepository.deleteAll();
    }

    void saveGrailsBooks() {
        grailsBookRepository.save(new Book("Grails 3 - Step by Step"));
        grailsBookRepository.save(new Book("Grails Goodness Notebook"));
        grailsBookRepository.save(new Book("Falando de Grails"));
        grailsBookRepository.save(new Book("Grails in Action"));
        grailsBookRepository.save(new Book("The Definitive Guide to Grails 2"));
        grailsBookRepository.save(new Book("Programming Grails"));
        grailsBookRepository.save(new Book("Grails 2: Quick Start Guide"));
    }

    void saveMicronautBooks() {
        micronautBookRepository.save(new Book("Introducing Micronaut: Build, Test and Deploy Java Microservices on Oracle Cloud"));
        micronautBookRepository.save(new Book("Building Microservices wiht Micronaut: A quick-start guide to building high-performance reactive microservices for Java developers"));
    }
}