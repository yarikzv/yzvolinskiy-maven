package org.homework16;

import org.homework16.interfaces.StringCollection;

import java.util.Arrays;

public class StringCollectionImpl implements StringCollection {
    private String[] array = new String[0];

    @Override
    public String get(int index) {
        return array[index];
    }

    @Override
    public boolean add(String str) {
        String[] newArray = new String[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[newArray.length - 1] = str;
        array = newArray;
        return true;
    }

    @Override
    public boolean add(int index, String str) {
        if (index > array.length + 1 || index < 0) {
            return false;
        } else {
            String[] newArray = new String[array.length + 1];
            int j=0;
            for (int i = 0; i < array.length; i++) {
                if (i != index) {
                    newArray[j] = array[i];
                    j++;
                } else {
                    newArray[j] = str;
                    newArray[j + 1] = array[i];
                    j+=2;
                }
            }
            array = newArray;
            return true;
        }
    }

    @Override
    public boolean delete(String str) {
        if (contains(str)) {
            String[] newArray = new String[array.length - 1];
            for (int i = 0; i < newArray.length; i++) {
                int j = i;
                if (array[i].equals(str)) {
                    j++;
                }
                newArray[i] = array[j];
            }
            array = newArray;
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(String str) {
        for (String s : array) {
            if (s.equals(str)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(StringCollection collection) {
        if (collection.size() == array.length) {
            for (int i = 0; i < collection.size(); i++) {
                if (!collection.get(i).equals(array[i])) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }

    @Override
    public boolean clear() {
        array = new String[0];
        return true;
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
