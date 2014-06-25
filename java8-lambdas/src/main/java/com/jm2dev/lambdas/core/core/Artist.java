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

    public boolean isFrom(String nationality) {
        return this.nationality.equals(nationality);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Artist artist = (Artist) o;

        if (!name.equals(artist.name)) return false;
        if (!nationality.equals(artist.nationality)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + nationality.hashCode();
        return result;
    }
}
