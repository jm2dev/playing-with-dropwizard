package com.jm2dev.lambdas.core;

import com.jm2dev.lambdas.core.core.Artist;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

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

    @Test
    public void artistIsFromGivenNationality() {
        assertTrue(artist.isFrom(nationality));
    }

    @Test
    public void isArtistSoloMember() {
        Artist paco = new Artist("Paco de Lucía", "Spain");
        assertTrue(paco.isSolo());
    }

    @Test
    public void bandWithMembers() {
        Artist andrea = new Artist("Andrea Corr", "Ireland");
        Artist caroline = new Artist("Caroline Corr", "Ireland");
        Artist jim = new Artist("Jim Corr", "Ireland");
        Artist sharon = new Artist("Sharon Corr", "Ireland");
        Artist theCorrs = new Artist("The Corrs"
                , "Ireland"
                , Arrays.asList(andrea, caroline, jim, sharon));
        assertFalse(theCorrs.isSolo());
    }
}
