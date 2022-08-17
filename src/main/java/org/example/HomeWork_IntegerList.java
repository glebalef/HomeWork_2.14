package org.example;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

import static org.example.SortingsTesting.swapElements;

public class HomeWork_IntegerList implements IntegerList {
    private Integer[] integers;
    private int arrayLength;

    public HomeWork_IntegerList() {
        integers = new Integer[10];
    }

    public HomeWork_IntegerList(int initSize) {
        integers = new Integer[initSize];
        sort(integers, 0, integers.length-1);
    }


    @Override
    public String toString() {
        return Arrays.toString(integers);
    }

    private void validateItem(Integer item) {
        if (item == null) {
            throw new NullItemException();
        }
    }

    private void validateSize() {
        if (arrayLength == integers.length) {
            grow();
        }
    }

    private void validateIndex(int index) {
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

    public Integer[] getIntegers() {
        return integers;
    }


    // тут начинаются методы интерфейса
    @Override
    public Integer add(Integer item) {
        validateSize();
        validateItem(item);
        integers[arrayLength++] = item;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        validateSize();
        validateItem(item);
        validateIndex(index);
        if (index == arrayLength) {
            integers[arrayLength++] = item;
            return item;
        }
        System.arraycopy(integers, index, integers, index + 1, arrayLength - index);
        integers[index] = item;
        arrayLength++;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        validateIndex(index);
        validateItem(item);
        integers[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        validateItem(item);
        int index = indexOf(item);
        if (index == -1) {
            throw new ElementNotFoundException();
        }
        if (index != arrayLength) {
            integers[arrayLength--] = null;
            System.arraycopy(integers, index + 1, integers, index, arrayLength - index);
        }
        arrayLength--;
        return item;
    }

    @Override
    public Integer remove(int index) {
        validateIndex(index);
        Integer item = integers[index];
        if (index != arrayLength) {
            integers[arrayLength--] = null;
            System.arraycopy(integers, index + 1, integers, index, arrayLength - index);
        }
        arrayLength--;
        return item;
    }

    @Override
    public boolean contains(Integer item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < arrayLength; i++) {
            if (integers[i].equals(item)) return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = arrayLength - 1; i >= 0; i--) {
            if (integers[i].equals(item)) return i;
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        validateIndex(index);
        return integers[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
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
    public Integer[] toArray() {
        return Arrays.copyOf(integers, arrayLength);
    }

    private static boolean contains(int[] arr, int element) {
        int min = 0;
        int max = arr.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (element == arr[mid]) {
                return true;
            }

            if (element < arr[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }
    public static void sortSelection(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
        }
    }

    public static void sort(Integer[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            sort(arr, begin, partitionIndex - 1);
            sort(arr, partitionIndex + 1, end);
        }
    }

    private static Integer partition(Integer[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;
                swapElements(arr, i, j);
            }
        }
        swapElements(arr, i + 1, end);
        return i + 1;
    }

    private static void swapElements(Integer @NotNull [] arr, int i1, int i2) {
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }

    private void grow () {
           integers =  Arrays.copyOf(integers, (int) (arrayLength*1.5));
    }
}
