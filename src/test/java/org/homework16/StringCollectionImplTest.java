package org.homework16;

import org.homework16.interfaces.StringCollection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StringCollectionImplTest {
    private static StringCollectionImpl collection;
    private static StringCollection collection1;

    private static void addingToCollection() {
        collection.add("One");
        collection.add("Two");
    }

    private static void addingToCollection1() {
        collection1.add("One");
        collection1.add("Two");
    }


    @BeforeEach
    public void createNewCollection() {
        collection = new StringCollectionImpl();
    }


    @Test
    public void shouldGetSize() {
        Assertions.assertEquals(0, collection.size());
    }

    @Test
    public void shouldAddElementToCollection() {
        addingToCollection();
        Assertions.assertEquals(2, collection.size());
    }

    @Test
    public void shouldGetElementByIndex() {
        addingToCollection();
        Assertions.assertEquals("Two", collection.get(1));
    }

    @Test
    public void shouldAddElementByIndex() {
        addingToCollection();
        collection.add(1, "Three");
        Assertions.assertEquals("Three", collection.get(1));
    }

    @Test
    public void shouldNotAddElementByIndex() {
        Assertions.assertFalse(collection.add(2, "Three"));
    }

    @Test
    public void shouldDeleteElementByValue() {
        addingToCollection();
        collection.delete("Two");
        Assertions.assertEquals(1, collection.size());
    }

    @Test
    public void shouldBeFalseDeleteElementByValue() {
        Assertions.assertFalse(collection.delete("One"));
    }

    @Test
    public void shouldBeTrueContainsValue() {
        addingToCollection();
        Assertions.assertTrue(collection.contains("One"));
    }

    @Test
    public void shouldBeFalseContainsValue() {
        addingToCollection();
        Assertions.assertFalse(collection.contains("Three"));
    }

    @Test
    public void shouldBeTrueEquals() {
        addingToCollection();
        collection1 = new StringCollectionImpl();
        addingToCollection1();
        Assertions.assertTrue(collection1.equals(collection));
    }

    @Test
    public void shouldBeFalseEqualsMismatchedSize() {
        addingToCollection();
        collection1 = new StringCollectionImpl();
        addingToCollection1();
        collection1.add("Three");
        Assertions.assertFalse(collection1.equals(collection));
    }

    @Test
    public void shouldBeFalseEqualsMismatchedElements() {
        addingToCollection();
        collection1 = new StringCollectionImpl();
        collection1.add("Test");
        collection1.add("Unit");
        Assertions.assertFalse(collection1.equals(collection));
    }

    @Test
    public void shouldBeSymmetricEqualsAndHashCode() {
        addingToCollection();
        collection1 = new StringCollectionImpl();
        collection1.add("One");
        collection1.add("Two");
        Assertions.assertTrue(collection.equals(collection1) && collection1.equals(collection));
        Assertions.assertEquals(collection.hashCode(), collection1.hashCode());
    }

    @Test
    public void shouldGetClear() {
        addingToCollection();
        collection.clear();
        Assertions.assertEquals(0, collection.size());
    }
}
