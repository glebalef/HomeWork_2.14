package org.example;

import java.net.SocketTimeoutException;
import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {

        HomeWork_ArrayList test = new HomeWork_ArrayList(5);


        test.add("bulochka");
        test.add("masha");
        test.add(2,"vzhik");
        test.add(1,"pipa");
        System.out.println(test);
    }
}