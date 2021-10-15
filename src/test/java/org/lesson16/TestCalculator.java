package org.lesson16;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestCalculator {

    @Test
    public void test_sum_normal_case(){
        Assertions.assertEquals(4,Calculator.sum(3,1));
    }
    @Test
    public void test_sum_divide_case(){
        Assertions.assertThrows(ArithmeticException.class, () -> Calculator.divide(3,0));
    }

}
