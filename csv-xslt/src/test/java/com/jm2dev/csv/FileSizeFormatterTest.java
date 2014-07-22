package com.jm2dev.csv;

import org.junit.Test;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import static org.apache.commons.io.FileUtils.byteCountToDisplaySize;

public class FileSizeFormatterTest {
    private String prettyPrint(long filesize) {
        String result = byteCountToDisplaySize(filesize);
        return result;
    }

    @Test
    public void transformBytesIntoBytes() {
        long filesize = 786;
        String expected = "786 bytes";
        assertThat(prettyPrint(filesize), is(expected));
    }

    @Test
    public void transformBytesIntoKiloBytes() {
        long filesize = 456321;
        String expected = "445 KB" ;
        assertThat(prettyPrint(filesize), is(expected));
    }

    @Test
    public void transformBytesIntoMegaBytes() {
        long filesize = 896789489;
        String expected = "855 MB";
        assertThat(prettyPrint(filesize), is(expected));
    }
}
