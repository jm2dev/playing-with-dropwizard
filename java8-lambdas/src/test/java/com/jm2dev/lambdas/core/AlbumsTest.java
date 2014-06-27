package com.jm2dev.lambdas.core;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AlbumsTest {
    @Test
    public void albumsWithMoreThanThreeTracks() {
        List<Album> albums = SampleData.allAlbums()
                .filter(album -> album.getTracks().size() > 3)
                .collect(toList());
        assertThat(albums, is(Arrays.asList(SampleData.forgivenNotForgotten)));
    }
}
