package com.jm2dev.lambdas.core.core;

import java.util.List;
import java.util.Objects;

public final class Album {
    private String name;
    private List<Artist> artists;

    public Album(String name, List<Artist> artists) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(artists);
        this.name = name;
        this.artists = artists;
    }

    public String getName() {
        return name;
    }

    public List<Artist> getArtists() {
        return artists;
    }
}
