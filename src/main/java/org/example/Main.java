package org.example;

public class Main {
    public static void main(String[] args) {

        HomeWork_ArrayList test = new HomeWork_ArrayList(10);

        test.add(3,"test");
        test.add("pipa");
        test.add("bulochka");
        test.add("masha");
        test.add("vzhik");
        test.add("agsay");
        test.add("homelander");
        test.add("starlight");
        test.add("deep");
        test.add("stormfront");
        test.set(3,"test2");
        test.remove("test2");



        System.out.println(test);



    }



}