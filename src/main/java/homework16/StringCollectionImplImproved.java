package homework16;

import homework16.interfaces.StringCollection;

import java.util.Arrays;

/**
 * An improved class of collection. Implements StringCollection interface.
 * Uses some native methods from java.util.Arrays and System classes
 * for performance improving.
 * Can work with String and null as elements of collection.
 * <p>
 * Added indexOf() method, not specified in StringCollection interface.
 * <p>
 * * @author Yaroslav Zvolinskiy.
 * * @version 0.0.1
 */
public class StringCollectionImplImproved implements StringCollection {
    private String[] array = new String[0];

    /**
     * Getting element by index.
     *
     * @param index Index of element.
     * @return Element.
     */
    @Override
    public String get(int index) {
        return array[index];
    }

    /**
     * Adds string element to collection.
     *
     * @param str Element for adding.
     * @return True.
     */
    @Override
    public boolean add(String str) {
        String[] newArray = Arrays.copyOf(array, array.length + 1);
        try {
            newArray[newArray.length - 1] = str;
        } catch (NullPointerException e) {
            newArray[newArray.length - 1] = null;
        }
        array = newArray;
        return true;
    }

    /**
     * Inserts string element to collection by index.
     *
     * @param index Insertion place's index.
     * @param str   Element for insertion.
     * @return True if index exist and insertion successful.
     */
    @Override
    public boolean add(int index, String str) {
        if (index > array.length + 1 || index < 0) {
            return false;
        } else {
            String[] newArray = new String[array.length + 1];
            System.arraycopy(array, 0, newArray, 0, index);
            newArray[index] = str;
            System.arraycopy(array, index, newArray, index + 1, array.length - index);
            array = newArray;
            return true;
        }
    }

    /**
     * Deletes an element from the collection by index.
     * Creates a copy of the array without element.
     *
     * @param index Content of element to deleting.
     * @return True if success.
     */
    public boolean delete(int index) {
        if (index > 0 && index < array.length) {
            String[] newArray;
            newArray = new String[array.length - 1];
            System.arraycopy(array, 0, newArray, 0, index);
            System.arraycopy(array, index + 1, newArray, index, array.length - (index + 1));
            array = newArray;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Overloaded version of delete(int index). Calls delete(int index).
     * Deleting an element from the collection by content.
     *
     * @param str Content of element to deleting.
     * @return True if success.
     */
    @Override
    public boolean delete(String str) {
        int index = indexOf(str);
        return delete(index);
    }

    /**
     * Checking if collection contains element from @param.
     * Catching NullPointerException.
     *
     * @param str Searched element. Can be null.
     * @return True if str exist.
     */
    @Override
    public boolean contains(String str) {
        for (String s : array) {
            try {
                if (s.equals(str)) {
                    return true;
                }
            } catch (NullPointerException e) {
                return true;
            }
        }
        return false;
    }

    /**
     * Overriding equals() for comparing current collection with @param.
     *
     * @param collection Another StringCollection member for comparison.
     * @return True if arrays of collections are equal.
     */
    @Override
    public boolean equals(StringCollection collection) {
        if (collection.size() == array.length) {
            for (int i = 0; i < collection.size(); i++) {
                try {
                    return collection.get(i).equals(array[i]);
                } catch (NullPointerException e) {
                    return collection.get(i) == null && array[i] == null;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     * Overriding hashCode(), because the equals() method was overridden.
     *
     * @return Hash code by Arrays.hashCode() method.
     */
    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }

    /**
     * Clearing of collection by creating new array with length '0'.
     *
     * @return True.
     */
    @Override
    public boolean clear() {
        array = new String[0];
        return true;
    }

    /**
     * Size of collection.
     *
     * @return Size by .length method.
     */
    @Override
    public int size() {
        return array.length;
    }

    /**
     * Overriding toString() for more attractive displaying of collection.
     *
     * @return Result as Arrays.toString() method.
     */
    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    /**
     * Returns index of str if existed.
     *
     * @param str Searched String element of collection.
     * @return Index of item or -1 if not exist.
     */
    public int indexOf(String str) {
        for (int i = 0; i < array.length; i++) {
            try {
                if (array[i].equals(str)) {
                    return i;
                }
            } catch (NullPointerException e) {
                return i;
            }
        }
        return -1;
    }
}
