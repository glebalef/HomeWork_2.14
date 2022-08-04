package org.example;

import java.util.Arrays;

public class HomeWork_ArrayList implements StringList {
    private final String[] strings;
    private int arrayLength;

    public HomeWork_ArrayList() {
        strings = new String[10];
    }
    public HomeWork_ArrayList (int initSize) {
        strings = new String[initSize];
    }

    private void validateItem (String item) {
            if (item == null) {
                throw new NullItemException();
            }
        }

        private void validateSize () {
            if (arrayLength == strings.length) {
                throw new StringsIsFullException();
            }
        }

        private void validateIndex (int index) {
            if (index > 0 || index > arrayLength) {
                throw new InvalidIndexException();
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
        validateSize();
        validateItem(item);
        strings[arrayLength++] = item;
        return item;
    }

    @Override
    public String add(int index, String item) {
        validateSize();
        validateItem(item);
        validateIndex(index);
        if (index == arrayLength) {
            strings[arrayLength++] = item;
            return item;
        }
         System.arraycopy(strings, index, strings, index+1,arrayLength-index);
        strings[index] = item;
        arrayLength++;
        return item;
    }

    @Override
    public String set(int index, String item) {
       validateIndex(index);
       validateItem(item);
        strings[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        validateItem(item);
        int index = indexOf(item);
        if (index == -1) {
            throw new ElementNotFoundException();
        }
        if (index != arrayLength) {
            strings[arrayLength--] = null;
            System.arraycopy(strings, index + 1, strings, index, arrayLength - index);
        }
        arrayLength--;
        return item;
    }

    @Override
    public String remove(int index) {
        validateIndex(index);
        String item = strings[index];
        if (index != arrayLength) {
            strings[arrayLength--] = null;
            System.arraycopy(strings, index + 1, strings, index, arrayLength - index);
        }
        arrayLength--;
        return item;
    }

    @Override
    public boolean contains(String item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < arrayLength; i++) {
            if (strings[i].equals(item)) return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = arrayLength-1; i >= 0; i--) {
            if (strings[i].equals(item)) return i;
        }
        return -1;
    }

    @Override
    public String get(int index) {
        validateIndex(index);
        return strings[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        return arrayLength;
    }

    @Override
    public boolean isEmpty() {
        return arrayLength == 0;
    }

    @Override
    public void clear() {
    arrayLength = 0;
        }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(strings,arrayLength);
    }
}
