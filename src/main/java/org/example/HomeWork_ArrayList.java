package org.example;

import java.util.Arrays;
import java.util.spi.AbstractResourceBundleProvider;

public class HomeWork_ArrayList implements StringList {

    private int arrayLength;
    private String[] strings;

    public HomeWork_ArrayList(int arrayLength) {
        this.arrayLength = arrayLength;
        this.strings = new String[arrayLength];
        for (int i = 0; i < this.strings.length; i++) {
            this.strings[i] = "";
        }
    }

    private static void isNotNull(String item) {
        if (item == null) {
            throw new RuntimeException("Пустое значение в массив поместить нельзя!");
        }
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

    // тут начинаются методы интерфейса
    @Override
    public String add(String item) {
        isNotNull(item);
        for (int i = 0; i < strings.length; i++) {
            if (strings[i] == "") {
                strings[i] = item;
                break;
            }
        }
        return item;
    }

    @Override
    public String add(int index, String item) {
        if (index > strings.length - 1) throw new RuntimeException("нельзя передать такой индекс!");
        else if (item == null) throw new RuntimeException("нельзя передать null!");
        String[] stringsNew = new String[arrayLength];
        for (int i = 0; i < stringsNew.length; i++) {
            stringsNew[i] = strings[i];
        }
        for (int i = index; i < strings.length - index; i++) {
            strings[i + 1] = stringsNew[i];
        }
        strings[index] = item;
        return item;
    }

    @Override
    public String set(int index, String item) {
        if (index > strings.length - 1) throw new RuntimeException("нельзя передать такой индекс!");
        else if (item == null) throw new RuntimeException("нельзя передать null!");
     else strings[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].equals(item)) {
                strings[i] = "";
                break;
            }
        }
        return item;
    }

    @Override
    public String remove(int index) {
        if (index > strings.length - 1) {
            throw new RuntimeException("нельзя передать такой индекс!");
        }
        for (int i = 0; i < strings.length; i++) {
        }
        strings[index] = "";
        return strings[index];
    }

    @Override
    public boolean contains(String item) {

        for (int i = 0; i < strings.length; i++) {
            if (strings[i].equals(item)) return true;
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].equals(item)) return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        String[] newStrings = new String[strings.length];
        for (int i = 0; i < strings.length; i++) {
            newStrings[i] = strings[strings.length - 1 - i];
            if (newStrings[i].equals(item)) return i;
        }
        return -1;
    }

    @Override
    public String get(int index) {
        if (index > arrayLength) throw new RuntimeException("нельзя передать такой индекс!");
        return strings[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (otherList == null) throw new RuntimeException("нельзя передать null!");
        if (strings.equals(otherList)) return true;
        return false;
    }

    @Override
    public int size() {
        int counter=0;
        for (int i = 0; i < strings.length; i++) {
            if (strings[i] != "") counter++;
        } return counter;
    }

    @Override
    public boolean isEmpty() {
        int counter = 0;
        for (int i = 0; i < strings.length; i++) {
            if (strings[i] != "") counter++;
            if (counter == 0)
                return true;
        }       return false;
    }

    @Override
    public void clear() {
        int counter = 0;
        for (int i = 0; i < strings.length; i++) {
            if (strings[i] != "") counter++; }
            if (counter == 0) throw new RuntimeException("в массиве нет эелементов!");
        for (int i = 0; i < strings.length; i++) {
            strings[i] = "";
        }
    }

    @Override
    public String[] toArray() {
        String[] result = new String[arrayLength];
        for (int i = 0; i < strings.length; i++) {
            result [i] = strings [i];
        }
        return result;
    }
}
