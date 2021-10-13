package homework16;

import homework16.interfaces.StringCollection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StringCollectionImplImprovedTest {
    private static StringCollectionImplImproved collection;
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
        collection = new StringCollectionImplImproved();
    }

    @Test
    public void sizeShouldBeZero() {
        Assertions.assertEquals(0, collection.size());
    }

    @Test
    public void addShouldGiveSizeTwo() {
        addingToCollection();
        Assertions.assertEquals(2, collection.size());
    }

    @Test
    public void addNullShouldGiveSizeOne(){
        collection.add(null);
        Assertions.assertEquals(1, collection.size());
    }

    @Test
    public void getShouldGiveStringTwo() {
        addingToCollection();
        Assertions.assertEquals("Two", collection.get(1));
    }

    @Test
    public void addByIndexShouldGiveStringTwo() {
        addingToCollection();
        collection.add(1, "Three");
        Assertions.assertEquals("Three", collection.get(1));
    }

    @Test
    public void addByIndexShouldBeFalse() {
        Assertions.assertFalse(collection.add(2,"Three"));
    }
    @Test
    public void deleteShouldGiveSizeTwo() {
        addingToCollection();
        collection.delete("Two");
        Assertions.assertEquals(1, collection.size());
    }

    @Test
    public void deleteShouldBeFalse() {
        Assertions.assertFalse(collection.delete("One"));
    }

    @Test
    public void deleteByIndexShouldGiveSizeOne(){
        addingToCollection();
        collection.delete(1);
        Assertions.assertEquals(1, collection.size());
    }

    @Test
    public void deleteByIndexShouldBeFalse() {
        addingToCollection();
        Assertions.assertFalse(collection.delete(2));
    }

    @Test
    public void containsShouldBeTrue() {
        addingToCollection();
        Assertions.assertTrue(collection.contains("One"));
    }

    @Test
    public void containsShouldBeFalse() {
        addingToCollection();
        Assertions.assertFalse(collection.contains("Three"));
    }

    @Test
    public void containsNullShouldBeTrue() {
        collection.add(null);
        Assertions.assertTrue(collection.contains(null));
    }

    @Test
    public void equalsShouldBeTrue() {
        addingToCollection();
        collection1 = new StringCollectionImplImproved();
        addingToCollection1();
        Assertions.assertTrue(collection1.equals(collection));
    }

    @Test
    public void equalsMismatchedSizeShouldBeFalse() {
        addingToCollection();
        collection1 = new StringCollectionImplImproved();
        addingToCollection1();
        collection1.add("Three");
        Assertions.assertFalse(collection1.equals(collection));
    }

    @Test
    public void equalsMismatchedElementsShouldBeFalse(){
        addingToCollection();
        collection1 = new StringCollectionImplImproved();
        collection1.add("Test");
        collection1.add("Unit");
        Assertions.assertFalse(collection1.equals(collection));
    }

    @Test
    public void equalsWithNullShouldBeTrue() {
        collection.add(null);
        collection1 = new StringCollectionImplImproved();
        collection1.add(null);
        Assertions.assertTrue(collection1.equals(collection));
    }

    @Test
    public void equalsAndHashCodeShouldBeSymmetric(){
        addingToCollection();
        collection1 = new StringCollectionImplImproved();
        collection1.add("One");
        collection1.add("Two");
        Assertions.assertTrue(collection.equals(collection1) && collection1.equals(collection));
        Assertions.assertEquals(collection.hashCode(), collection1.hashCode());
    }

    @Test
    public void clearShouldGiveSizeZero() {
        addingToCollection();
        collection.clear();
        Assertions.assertEquals(0, collection.size());
    }

    @Test
    public void addNullShouldThrowException() {
        Assertions.assertDoesNotThrow(() -> collection.add(null));
    }

    @Test
    public void indexOfShouldGiveZero(){
        addingToCollection();
        Assertions.assertEquals(0, collection.indexOf("One"));
    }

    @Test
    public void indexOfShouldGiveMinusOne(){
        Assertions.assertEquals(-1, collection.indexOf("One"));
    }

    @Test
    public void indexOfNullShouldGiveZero(){
        collection.add(null);
        Assertions.assertEquals(0, collection.indexOf(null));
    }
}