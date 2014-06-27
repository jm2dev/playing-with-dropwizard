package com.jm2dev.lambdas.core;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

public final class SampleData {
    // artists
    public final static Artist paco = new Artist("Paco de Lucía", "Spain");
    public final static Artist andrea = new Artist("Andrea Corr", "Ireland");
    public final static Artist caroline = new Artist("Caroline Corr", "Ireland");
    public final static Artist jim = new Artist("Jim Corr", "Ireland");
    public final static Artist sharon = new Artist("Sharon Corr", "Ireland");

    // bands
    public final static Artist theCorrs = new Artist("The Corrs"
            , "Ireland"
            , asList(andrea, caroline, jim, sharon));

    // tracks
    private final static List<Track> forgivenNotForgottenTracks = Arrays.asList(
            new Track("Erin Shore", 27),
            new Track("Forgiven, Not Forgotten", 415),
            new Track("Heaven Knows", 418),
            new Track("Along with the Girls", 49),
            new Track("Someday", 351),
            new Track("Runaway", 424),
            new Track("The Right Time", 407),
            new Track("The Minstrel Boy", 212),
            new Track("Toss the Feathers", 250),
            new Track("Love to Love You", 408),
            new Track("Secret Life", 431),
            new Track("Carraroe Jig", 52),
            new Track("Closer", 405),
            new Track("Leave Me Alone", 340),
            new Track("Erin Shore", 414)
    );

    // albums
    public final static Album forgivenNotForgotten = new Album("Forgiven , not forgotten",
            Arrays.asList(theCorrs),
            forgivenNotForgottenTracks);

    // etc
    public final static List<Artist> allArtists = asList(paco,
            andrea, caroline, jim, sharon, theCorrs);

    public static Stream<Album> allAlbums() {
        return Stream.of(forgivenNotForgotten);
    }
}
