package com.micronautbook.data;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
@MappedEntity
public record Book(
    @GeneratedValue
    @Id Long id,
    String title
) {

}
