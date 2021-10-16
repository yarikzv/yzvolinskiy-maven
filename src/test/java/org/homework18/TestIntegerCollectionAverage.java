package org.homework18;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TestIntegerCollectionAverage {

    @Test
    public void shouldGetAverageOfCollection() {
        // given
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8);

        // expected
        double expectedAverage = 4.5;

        // actual
        double actualAverage = IntegerCollectionAverage.integerCollectionAverage(list);

        // assert
        Assertions.assertEquals(expectedAverage, actualAverage);
    }

    @Test
    public void shouldNotThrowException() {
        // given
        List<Integer> list = new ArrayList<>();

        //assert
        Assertions.assertDoesNotThrow(() -> IntegerCollectionAverage.integerCollectionAverage(list));
    }
}
