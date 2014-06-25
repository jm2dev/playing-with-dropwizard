package com.jm2dev.lambdas.core;

import com.jm2dev.lambdas.core.core.Artist;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static java.util.stream.Collectors.toList;

public class ArtistsTest {
    String irish = "Ireland";
    Artist andrea_corr = new Artist("Andrea Corr", irish);
    Artist bono = new Artist("Bono", irish);
    String spanish  = "Spain";
    Artist paco_de_lucia = new Artist("Paco de Lucia", spanish);

    List<Artist> artists = Arrays.asList(andrea_corr, bono);

    @Test
    public void countArtistWithGivenNationality() {
        long howManyIrishArtists = artists.stream()
                .filter(artist -> artist.isFrom("Ireland"))
                .count();

        assertThat(howManyIrishArtists, is(equalTo(2L)));
    }

    @Test
    public void filterIrishArtists() {
        List<Artist> irishArtists = artists.stream()
                .filter(artist -> artist.isFrom("Ireland"))
                .collect(toList());
        assertThat(irishArtists, hasItems(andrea_corr, bono));
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
        Artist corr = new Artist("ANDREA CORR", irish);
        List<Artist> capitalizedArtists = artists.stream()
                .map(artist -> capitalize(artist))
                .collect(toList());
        assertThat(capitalizedArtists, hasItem(corr));

    }
}
