package com.jm2dev.lambdas.core;

import org.junit.Test;

import java.util.Collections;

public class AlbumTest {
    @Test(expected = Exception.class)
    public void mustHaveName() {
        Album album = new Album(null, Collections.<Artist>emptyList(), Collections.<Track>emptyList());
    }

    @Test(expected = Exception.class)
    public void mustHaveArtists() {
        Album album = new Album("Best of", null, Collections.<Track>emptyList());
    }

    @Test(expected = Exception.class)
    public void mustHaveTracks() {
        Album album = new Album("Best of", Collections.<Artist>emptyList(), null);
    }
}

