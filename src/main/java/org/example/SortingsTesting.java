package org.example;

import java.util.Arrays;

public class SortingsTesting {

    public static void main(String[] args) {

        Integer[] testArray = new Integer[100000];

        for (int i = 0; i < testArray.length; i++) {
            testArray[i] = ((int) (Math.random() * 31) - 15);

            Arrays.copyOf(testArray, testArray.length);
        }

// Запуск сортировок

        long startBubble = System.currentTimeMillis();
        sortBubble(Arrays.copyOf(testArray, testArray.length));
        System.out.println(System.currentTimeMillis() - startBubble);

        long startSelection = System.currentTimeMillis();
        sortSelection(Arrays.copyOf(testArray, testArray.length));
        System.out.println(System.currentTimeMillis() - startSelection);

        long startInsertion = System.currentTimeMillis();
        sortInsertion(Arrays.copyOf(testArray, testArray.length));
        System.out.println(System.currentTimeMillis() - startInsertion);


    }


    // методы сортировки
    static void swapElements(Integer[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

    public static void sortBubble(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapElements(arr, j, j + 1);
                }
            }
        }
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

    public static void sortInsertion(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }
}

