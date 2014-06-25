package com.jm2dev.lambdas.core;

import com.jm2dev.lambdas.core.core.Artist;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class ArtistsTest {
    @Test
    public void countArtistWithGivenNationality() {
        long howManyIrishArtists = SampleData.allArtists.stream()
                .filter(artist -> artist.isFrom("Ireland"))
                .count();

        assertThat(howManyIrishArtists, is(equalTo(5L)));
    }

    @Test
    public void filterIrishArtists() {
        List<Artist> irishArtists = SampleData.allArtists.stream()
                .filter(artist -> artist.isFrom("Ireland"))
                .collect(toList());
        assertThat(irishArtists,
                hasItems(SampleData.andrea,
                        SampleData.caroline,
                        SampleData.jim,
                        SampleData.sharon,
                        SampleData.theCorrs));
    }

    @Test
    public void capitalizeArtistNames() {
        List<String> capitalizedArtists = Stream.of("Andrea Corr", "Bono", "Paco de Lucia")
                .map(string -> string.toUpperCase())
                .collect(toList());
        assertThat(capitalizedArtists, hasItems("ANDREA CORR", "BONO", "PACO DE LUCIA"));
    }

    private Artist capitalize(Artist artist) {
        return new Artist(artist.getName().toUpperCase(), artist.getNationality());
    }

    @Test
    public void capitalizedArtists() {
        Artist corr = new Artist("ANDREA CORR", "Ireland");
        List<Artist> capitalizedArtists = SampleData.allArtists.stream()
                .map(artist -> capitalize(artist))
                .collect(toList());
        assertThat(capitalizedArtists, hasItem(corr));

    }

    @Test
    public void getArtistNationalityPlayingGivenAlbum() {
        List<String> nationalities = SampleData.forgivenNotForgotten.getArtists().stream()
                .filter(artist -> !artist.isSolo())
                .map(artist -> artist.getNationality())
                .collect(toList());
        assertThat("Forgiven, not forgotten is played by an irish band",
                Arrays.asList("Ireland"),
                is(nationalities));
    }
}
