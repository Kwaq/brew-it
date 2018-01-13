package org.kwaq.brewit.entity;

import java.time.LocalDate;

public class Recipe {

    private final Long id;

    private final String name;

    private final LocalDate creationDate;

    public Recipe(final String name, final LocalDate creationDate) {
        this(null, name, creationDate);
    }

    public Recipe(final Long id, final String name, final LocalDate creationDate) {
        this.id = id;
        this.name = name;
        this.creationDate = creationDate;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
