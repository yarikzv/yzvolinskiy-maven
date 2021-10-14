package homework18;

import java.util.Collection;

/**
 * A simple class for Stream API demonstration.
 * Has one static method {@code integerCollectionAverage()}.
 * Uses {@code stream()} and lambda.
 */
public class IntegerCollectionAverage {
    /**
     * The method gets value from Integer collections, calculates the average
     * and returns double value of average.
     *
     * @param collection Any collection with the Integer elements.
     * @return Double value of the average of collection's elements.
     */
    public static double integerCollectionAverage(Collection<Integer> collection){
        return collection.stream()
                .mapToInt(Integer::intValue)
                .average().orElse(Double.NaN);
    }
}
