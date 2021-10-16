package org.homework18;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TestStringCollectionFiltration {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    // Testing by capturing output stream
    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void shouldGetFiltratedListFromList() {
        // given
        List<String> givenList = List.of("Lorem", "Ipsum", "dolor", "sit", "amet", "Ut", "Excepteur", "duis",
                "laboris", "ullamco", "nemo", "harum", "aliquam", "At");

        // expected
        List<String> expectedList = List.of("amet", "duis", "nemo");

        // actual
        StringCollectionFiltration.stringCollectionFiltration(givenList);
        List<String> actualList = Arrays.stream(outputStreamCaptor
                        .toString()
                        .trim().split("\\W+"))
                .collect(Collectors.toList());

        // assert
        Assertions.assertEquals(expectedList, actualList);
    }

    @Test
    public void shouldGetFiltratedListFromSet() {
        // given
        Set<String> givenSet = Set.of("Alfa", "bravo", "Charlie", "delta", "echo", "Foxtrot",
                "Golf", "hotel", "india", "Juliett", "kilo");

        // expected
        List<String> expectedList = List.of("echo", "kilo");

        // actual
        StringCollectionFiltration.stringCollectionFiltration(givenSet);
        List<String> actualList = Arrays.stream(outputStreamCaptor
                        .toString()
                        .trim().split("\\W+"))
                .sorted()
                .collect(Collectors.toList());

        // assert
        Assertions.assertEquals(expectedList, actualList);
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
