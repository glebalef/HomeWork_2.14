package org.example;

import java.util.Arrays;

public class HomeWork_ArrayList implements StringList {

    private int arrayLength;
    private String[] strings;
    public HomeWork_ArrayList(int arrayLength) {
            this.arrayLength = arrayLength;
            this.strings = new String[arrayLength];
    }

    public int getArrayLength() {
        return arrayLength;
    }

    public String[] getStrings() {
        return strings;
    }

    @Override
    public String toString() {
        return Arrays.toString(strings);
    }

    @Override
    public String add(String item) {
        for (int i = 0; i < strings.length; i++) {
            if (strings[i] == null) {
                strings[i] = item;
                break;
            }
        }  return item;
    }

    @Override
    public String add(int index, String item) {
        if (index > strings.length || strings[index] != null) {
            throw new RuntimeException();
        } else {
        }  strings[index] = item;
        return item;
    }

    @Override
    public String set(int index, String item) {
        if (index > strings.length) {
            throw new RuntimeException();
        } else {
        }  strings[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].equals(item)) {
                strings[i] = null;
            }
        } return item;
    }

    @Override
    public String remove(int index) {
        return null;
    }

    @Override
    public boolean contains(String item) {
        return false;
    }

    @Override
    public int indexOf(String item) {
        return 0;
    }

    @Override
    public int lastIndexOf(String item) {
        return 0;
    }

    @Override
    public String get(int index) {
        return null;
    }

    @Override
    public boolean equals(StringList otherList) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public String[] toArray() {
        return new String[0];
    }
}
