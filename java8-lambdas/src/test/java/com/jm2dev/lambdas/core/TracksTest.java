package com.jm2dev.lambdas.core;

import com.jm2dev.lambdas.core.core.Track;
import org.junit.Test;

import java.util.Comparator;
import java.util.stream.Stream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TracksTest {
    @Test
    public void shortestTrack() {
        Track rockyRoad = new Track("Rocky road", 252);
        Track emerald = new Track("Emerald", 452);

        Track shortestTrack = Stream.of(rockyRoad, emerald)
                .min(Comparator.comparing(track -> track.getLength()))
                .get();
        assertThat(shortestTrack, is(rockyRoad));
    }

    @Test
    public void longestTrack() {
        Track rockyRoad = new Track("Rocky road", 252);
        Track emerald = new Track("Emerald", 452);

        Track longestTrack = Stream.of(rockyRoad, emerald)
                .max(Comparator.comparing(track -> track.getLength()))
                .get();
        assertThat(longestTrack, is(emerald));
    }
}