package com.jm2dev.lambdas.core;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Stream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AccumulatorTest {
    @Test
    public void sumTheFirstTheNaturalNumbers() {
        int total = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .reduce(0, (x, y) -> x + y);

        assertThat(total, is(55));
    }

    private int addUp(Stream<Integer> numbers) {
        return numbers.reduce(0, (x, y) -> x + y);
    }

    @Test
    public void addUpEmptyStream() {
        Stream<Integer> integers = Collections.<Integer>emptyList().stream();
        assertThat(addUp(integers), is(0));
    }

    @Test
    public void addUpStreamOfIntegers() {
        Stream<Integer> integers = Arrays.asList(1, 2, 3).stream();
        assertThat(addUp(integers), is(6));
    }
}
