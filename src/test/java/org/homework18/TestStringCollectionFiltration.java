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


class TestStringCollectionFiltration {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    List<String> givenList = List.of("Lorem", "Ipsum", "dolor", "sit", "amet", "Ut", "Excepteur", "duis",
            "laboris", "ullamco", "nemo", "harum", "aliquam", "At");
    Set<String> givenSet = Set.copyOf(givenList);
    List<String> expectedList = List.of("amet", "duis", "nemo");

    // Testing by capturing output stream
    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void stringCollectionFiltration_List_ShouldGiveOutputCaptorSuccess() {
        StringCollectionFiltration.stringCollectionFiltration(givenList);
        Assertions.assertEquals(
                expectedList,
                Arrays.stream(outputStreamCaptor
                                .toString()
                                .trim().split("\\W+"))
                        .collect(Collectors.toList()));
    }

    @Test
    void stringCollectionFiltration_Set_ShouldGiveOutputCaptorSuccess() {
        StringCollectionFiltration.stringCollectionFiltration(givenSet);
        Assertions.assertEquals(
                expectedList,
                Arrays.stream(outputStreamCaptor
                                .toString()
                                .trim().split("\\W+"))
                        .sorted()
                        .collect(Collectors.toList()));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
