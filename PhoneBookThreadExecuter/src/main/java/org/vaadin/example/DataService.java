package org.vaadin.example;

import java.util.HashMap;
import java.util.Random;

public class DataService {

    static final int  databaseSize=9999;
    static HashMap<String, Person> resVal;

    public static HashMap<String, Person> getPeople() {

        HashMap<String, Person> people = generateDatabase();

        return people;
    }

    private static HashMap<String, Person> generateDatabase(){

        resVal = new HashMap<String,Person>();
        for (int i=0; i<databaseSize; i++){
            Person personElement = new Person();
            personElement.setName(generateString());
            personElement.setStreet(generateString());
            personElement.setCity(generateString());
            personElement.setCountry(generateString());
            personElement.setPhone(generatePhoneNumber());
            personElement.setEmail(generateEmail());

            resVal.put(personElement.getPhone(),personElement);
        }
        return resVal;
    }

    private static String generateString(){
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        StringBuilder sb = new StringBuilder();

        Random random = new Random();

        int length = 7;

        for(int i = 0; i < length; i++) {

            int index = random.nextInt(alphabet.length());

            char randomChar = alphabet.charAt(index);

            sb.append(randomChar);
        }

        String randomString = sb.toString();
        return randomString;
    }
    private static String generatePhoneNumber(){

        String resVal="+90";
        Random random = new Random();

        Integer randPart1 = random.nextInt(99999-10000)+10000;
        Integer randPart2 = random.nextInt(9999-1000)+1000;
        return resVal+randPart1.toString()+randPart2.toString();
    }
    private static String generateEmail(){
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        Random random = new Random();

        int length = 2;

        for(int i = 0; i < length; i++) {

            int index = random.nextInt(alphabet.length());
            int index2 = random.nextInt(alphabet.length());

            char randomChar = alphabet.charAt(index);
            char randomChar2 = alphabet.charAt(index2);

            sb.append(randomChar);
            sb2.append(randomChar2);
        }

        String randomString = sb.toString();
        String randomString2 = sb2.toString();
        String email = randomString + "@" +randomString2 + ".com";
        return email;
    }

}