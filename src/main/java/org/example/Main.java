package org.example;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {


        // String
//        HomeWork_StringList test = new HomeWork_StringList(5);
//
//
//        test.add("bulochka");
//        test.add("masha");
//        test.add(0, "vzhik");
//        System.out.println(test);


        // Integer

        HomeWork_IntegerList testInteger = new HomeWork_IntegerList(4);

        testInteger.add(1);
        testInteger.add(2);
        testInteger.add(3);
        testInteger.add(4);
        testInteger.add(5);

        System.out.println(testInteger.toString());


    }
}