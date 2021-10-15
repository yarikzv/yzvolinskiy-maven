package org.homework18;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class TestIntegerCollectionAverage {
    private final List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8);

    @Test
    void integerCollectionAverage_ShouldGive_4dot5() {
        Assertions.assertEquals(4.5, IntegerCollectionAverage.integerCollectionAverage(list));
    }

    @Test
    void integerCollectionAverage_ShouldNotGive_5() {
        Assertions.assertNotEquals(5, IntegerCollectionAverage.integerCollectionAverage(list));
    }
}
