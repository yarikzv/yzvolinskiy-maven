package org.homework18;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TestStringCollectionTransformation {

    @Test
    public void shouldGetTransformedListFromList() {
        // given
        List<String> givenList = List.of("Lorem", "Ipsum", "dolor", "sit", "amet", "Ut", "Excepteur", "Duis",
                "laboris", "ullamco", "Nemo", "harum", "aliquam", "At");

        // expected
        List<String> expectedList = List.of("IPSUM", "UT", "EXCEPTEUR", "AT");

        // actual
        Collection<String> actualList = StringCollectionTransformation
                .stringCollectionTransformation(givenList);
        // assert
        Assertions.assertEquals(expectedList, actualList);
    }

    @Test
    public void shouldGetTransformedListFromSet() {
        // given
        Set<String> givenSet = Set.of("Alfa", "bravo", "Charlie", "delta", "echo", "Foxtrot",
                "Golf", "hotel", "India", "Juliett", "kilo");

        // expected
        List<String> expectedList = List.of("ALFA", "INDIA");

        // actual
        Collection<String> actualSet = StringCollectionTransformation
                .stringCollectionTransformation(givenSet);

        // assert
        Assertions.assertEquals(
                expectedList
                        .stream()
                        .sorted()
                        .collect(Collectors.toList()),
                actualSet
                        .stream()
                        .sorted()
                        .collect(Collectors.toList()));
    }
}
