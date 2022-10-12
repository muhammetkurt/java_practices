package org.example;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {


    public static void main(String[] args) {
        HashMap<String, Test> testHashMap = new HashMap<>();

        for (Integer i = 0; i<10; i++){
            testHashMap.put(Integer.toString(i),new Test("str+"+Integer.toString(i),i));
        }

        testHashMap.values().forEach(test -> {
            if (test.getTestInteger()==5){
                return;
            }
            System.out.println(test.getTestInteger()+"is lower than 5");
        });

    }

}