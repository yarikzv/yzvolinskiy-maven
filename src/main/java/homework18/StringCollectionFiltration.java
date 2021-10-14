package homework18;

import java.util.Collection;

/**
 * A simple class for Stream API demonstration.
 * Has one static method {@code stringCollectionFiltration()}.
 * Uses {@code stream()} and lambda.
 */
public class StringCollectionFiltration {

    /**
     * The method for filtration of collections elements by lowercase and length equals 4.
     * Then displays the result to console.
     *
     * @param collection A collection with {@code String} elements.
     */
    public static void stringCollectionFiltration(Collection<String> collection) {
        collection
                .stream()
                .filter(x -> x.matches("[a-z]*") && x.length() == 4)
                .forEach(System.out::println);
    }
}
