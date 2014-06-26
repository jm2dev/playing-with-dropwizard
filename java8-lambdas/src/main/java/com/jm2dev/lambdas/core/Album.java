package com.jm2dev.lambdas.core;

import java.util.List;
import java.util.Objects;

public final class Album {
    private String name;
    private List<Artist> artists;
    private List<Track> tracks;

    public Album(String name, List<Artist> artists, List<Track> tracks) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(artists);
        Objects.requireNonNull(tracks);
        this.name = name;
        this.artists = artists;
        this.tracks = tracks;
    }

    public String getName() {
        return name;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public List<Track> getTracks() {
        return tracks;
    }
}
