package com.jm2dev.lambdas.core;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ArtistTest {
    @Test
    public void artistHasName() {
        assertThat(SampleData.paco.getName(), is("Paco de Lucía"));
    }

    @Test
    public void artistHasNationality() {
        assertThat(SampleData.paco.getNationality(), is("Spain"));
    }

    @Test(expected = Exception.class)
    public void invalidArtistWithNoName() {
        Artist artist = new Artist(null, "Spain");
    }

    @Test(expected = Exception.class)
    public void invalidArtistWithNoNationality() {
        Artist artist = new Artist("Paco de Lucía", null);
    }

    @Test
    public void artistIsFromGivenNationality() {
        assertTrue(SampleData.paco.isFrom("Spain"));
    }

    @Test
    public void isArtistSoloMember() {
        assertTrue(SampleData.paco.isSolo());
    }

    @Test
    public void bandWithMembers() {
        assertFalse(SampleData.theCorrs.isSolo());
    }
}
