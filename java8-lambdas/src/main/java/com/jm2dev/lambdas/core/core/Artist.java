package com.jm2dev.lambdas.core.core;

import java.util.Objects;

public final class Artist {
    private String name;
    private String nationality;

    public Artist(String name, String nationality) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(nationality);
        this.name = name;
        this.nationality = nationality;
    }

    public String getName() {
        return name;
    }

    public String getNationality() {
        return nationality;
    }
}
