package homework18;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * A simple class for Stream API demonstration.
 * Has one static method {@code stringCollectionTransformation()}.
 * Uses {@code stream()} and lambda.
 */
public class StringCollectionTransformation {

    /**
     * The method  makes filtration of collections elements by a first uppercase vowel letter.
     * Then converts words to uppercase and collect to {@code ArrayList}.
     *
     * @param collection A collection with {@code String} elements.
     * @return {@code Collection<String>} with transformed words.
     */
    public static Collection<String> stringCollectionTransformation(Collection<String> collection) {
        return collection
                .stream()
                .filter(x -> x.matches("[AEOUI].*"))
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }
}
