package com.jm2dev.lambdas.core;

import com.jm2dev.lambdas.core.core.Artist;

import java.util.List;

import static java.util.Arrays.asList;

public final class SampleData {
    public final static Artist paco = new Artist("Paco de Lucía", "Spain");
    public final static Artist andrea = new Artist("Andrea Corr", "Ireland");
    public final static Artist caroline = new Artist("Caroline Corr", "Ireland");
    public final static Artist jim = new Artist("Jim Corr", "Ireland");
    public final static Artist sharon = new Artist("Sharon Corr", "Ireland");
    public final static Artist theCorrs = new Artist("The Corrs"
            , "Ireland"
            , asList(andrea, caroline, jim, sharon));
    public final static List<Artist> allArtists = asList(paco,
            andrea, caroline, jim, sharon, theCorrs);
}
