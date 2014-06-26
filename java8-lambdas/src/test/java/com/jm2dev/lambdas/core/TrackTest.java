package com.jm2dev.lambdas.core;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class TrackTest {
    String name = "You raise me up";
    int length = 431;

    Track track = new Track(name, length);

    @Test
    public void aTrackHasNameAndLength() {
        assertThat(track.getName(), is(name));
        assertThat(track.getLength(), is(length));
    }

    @Test
    public void aTrackCanBeCopied() {
        Track clonedTrack = track.copy();
        assertThat(track.getName(), is(name));
        assertThat(track.getLength(), is(length));
    }
}
