package org.homework18;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class TestStringCollectionTransformation {

    List<String> givenList = List.of("Lorem", "Ipsum", "dolor", "sit", "amet", "Ut", "Excepteur", "Duis",
            "laboris", "ullamco", "Nemo", "harum", "aliquam", "At");
    Set<String> givenSet = Set.copyOf(givenList);
    List<String> expectedList = List.of("IPSUM", "UT", "EXCEPTEUR", "AT");

    @Test
    void stringCollectionTransformation_List_ShouldGiveExpectedList() {
        Assertions.assertEquals(expectedList,
                StringCollectionTransformation
                        .stringCollectionTransformation(givenList));
    }

    @Test
    void stringCollectionTransformation_Set_ShouldGiveExpectedList() {
        Assertions.assertEquals(expectedList
                        .stream()
                        .sorted()
                        .collect(Collectors.toList()),
                StringCollectionTransformation
                        .stringCollectionTransformation(givenSet)
                        .stream().sorted().collect(Collectors.toList()));
    }
}
