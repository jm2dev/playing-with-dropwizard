package com.jm2dev.lambdas.core;

import com.jm2dev.lambdas.core.core.Album;
import com.jm2dev.lambdas.core.core.Artist;
import org.junit.Test;

import java.util.Collections;

public class AlbumTest {
    @Test(expected = Exception.class)
    public void mustHaveName() {
        Album album = new Album(null, Collections.<Artist>emptyList());
    }

    @Test(expected = Exception.class)
    public void mustHaveArtists() {
        Album album = new Album("Best of", null);
    }
}

