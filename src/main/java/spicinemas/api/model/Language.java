package spicinemas.api.model;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Language {

    private String name;
    private Long id;

    public Language(String name, Long id) {
        this.name = name;
        this.id = id;
    }

    public Language(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public Long getId() {
        return id;
    }
}
