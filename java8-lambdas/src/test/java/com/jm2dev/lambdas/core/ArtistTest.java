package com.jm2dev.lambdas.core;

import com.jm2dev.lambdas.core.core.Artist;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ArtistTest {
    String name = "Celtic woman";
    String nationality = "Irish";
    Artist artist = new Artist(name, nationality);

    @Test
    public void artistHasName() {
        assertThat(artist.getName(), is(name));
    }

    @Test
    public void artistHasNationality() {
        assertThat(artist.getNationality(), is(nationality));
    }

    @Test(expected = Exception.class)
    public void invalidArtistWithNoName() {
        Artist artist = new Artist(null, nationality);
    }

    @Test(expected = Exception.class)
    public void invalidArtistWithNoNationality() {
        Artist artist = new Artist(name, null);
    }
}
