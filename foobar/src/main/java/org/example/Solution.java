///*  re-id
//package org.example;
//
//public class Solution {
//
//    public static String solution (int i){
//        String resVal = "";
//        String allPrime = allPrime();
////        if(i <= allPrime.length() - 5 && i>=0 ) {
////            for(int j=0; j<5; j++ ){
////                resVal = resVal + allPrime.charAt(j+i);
////            }
////        }
//
//        resVal = allPrime.substring(i,i+5);
//
//        return resVal;
//    }
//    public static String allPrime() {
//        String resVal="";
//        boolean isPrime = true;
//        int tempCounter=2;
//        while (resVal.length()<10006){
//            for(int j=2; j<tempCounter; j++){
//                if(tempCounter%j == 0){
//                    isPrime=false;
//                }
//            }
//            if (isPrime){
//                resVal = resVal+tempCounter;
//            }
//            isPrime=true;
//            tempCounter++;
//        }
//        return resVal;
//    }
//}*/
//
///* power-hungry5
//package org.example;
//
//import java.math.BigInteger;
//import java.util.Collections;
//import java.util.PriorityQueue;
//import java.util.Queue;
//
//public class Solution {
//
//    public static String solution(int[] xs) {
//
//        BigInteger resVal = new BigInteger("1");
//        int zeroCounter=0;
//        Queue<Integer> negativePriorityQueue = new PriorityQueue<Integer>(Collections.reverseOrder());
//        Queue<Integer> pozitivePriorityQueue = new PriorityQueue<Integer>();
//
//        for (int i=0; i< xs.length; i++){
//            if(xs[i]<0){
//                negativePriorityQueue.add(xs[i]);
//            }
//            else if(xs[i]>0){
//                pozitivePriorityQueue.add(xs[i]);
//
//                BigInteger b = new BigInteger(String.valueOf(xs[i]));
//                resVal = resVal.multiply(b);
//            } else if(xs[i]==0){
//                zeroCounter++;
//            }
//        }
//
//        if (zeroCounter==xs.length){
//            return "0";
//        }
//        if(xs.length==0){
//            return "0";
//        }
//        else if(xs.length==1){
//            return String.valueOf(xs[0]);
//        }
//        if(negativePriorityQueue.size()==1 && pozitivePriorityQueue.size()==0 && zeroCounter!=0){
//            return "0";
//        }
//        if(negativePriorityQueue.size() % 2 != 0){
//            negativePriorityQueue.poll();
//        }
//        int negQSize =negativePriorityQueue.size();
//        for(int i=0; i< negQSize; i++){
//            BigInteger b = new BigInteger(String.valueOf(negativePriorityQueue.poll()));
//
//            resVal = resVal.multiply(b);
//        }
//
//        return resVal.toString();
//    }
//
//}
//*/
//
///*
//* Please Pass the Coded Messages
//*
//*
//package org.example;
//
//import java.util.ArrayList;
//import java.util.Collections;
//
//public class Solution {
//
//
//    public static int solution(int[] l){
//
//        ArrayList<Integer> remainTwo = new ArrayList<Integer>();
//        ArrayList<Integer> remainOne = new ArrayList<Integer>();
//        ArrayList<Integer> resultArray = new ArrayList<Integer>();
//
//        for (int i=0;i<l.length; i++){
//            if(l[i] % 3 == 0){
//                resultArray.add(l[i]);
//            }
//            else if (l[i] % 3 == 2){
//                remainTwo.add(l[i]);
//            }
//            else if(l[i] % 3 == 1){
//                remainOne.add(l[i]);
//            }
//            else{
//                System.out.println("Debug line...");
//            }
//        }
//
//        remainTwo.sort(Collections.reverseOrder());
//        remainOne.sort(Collections.reverseOrder());
//
//        boolean addSubOfOne=false;
//        int loopOfRemainingOne = 0;
//
//        boolean addSubOfTwo=false;
//        int loopOfRemainingTwo = 0;
//
//        if ((remainOne.size()>remainTwo.size()) && remainTwo.size()>1){
//            resultArray.addAll(remainOne.subList(0, remainTwo.size()));
//            resultArray.addAll(remainTwo);
//            loopOfRemainingOne = (int) Math.floor(remainOne.subList(remainTwo.size(),remainOne.size()).size() / 3);
//
//            if ( loopOfRemainingOne >= 1){
//                addSubOfOne=true;
//            }
//        }
//        else if ((remainTwo.size()>remainOne.size() && remainOne.size()>1 ) ){
//            resultArray.addAll(remainTwo.subList(0, remainOne.size()));
//            resultArray.addAll(remainOne);
//            loopOfRemainingTwo = (int) Math.floor(remainTwo.subList(remainOne.size(),remainTwo.size()).size()/ 3);
//
//            if ( loopOfRemainingTwo >= 1){
//                addSubOfTwo=true;
//            }
//        }
//        if ((remainOne.size()==1 && remainTwo.size()==2) || (remainTwo.size()==1 && remainOne.size()==2)){
//            resultArray.addAll(remainOne);
//            resultArray.addAll(remainTwo);
//        }
//        else if(remainOne.size()<=1  && remainTwo.size()>2){
//            int loopCount=(int) Math.floor(remainTwo.size()/3);
//            for (int i=0; i<loopCount; i++){
//                resultArray.addAll(remainTwo.subList(   (i*3),  (i+1)*3) );
//            }
//        }
//        else if(remainTwo.size()<=1 && remainOne.size()>2){
//            int loopCount=(int) Math.floor(remainOne.size()/3);
//            for (int i=0; i<loopCount; i++){
//                resultArray.addAll(remainOne.subList(   (i*3),  (i+1)*3) );
//            }
//        }
//
//        if(addSubOfOne){
//            for (int i=0; i < loopOfRemainingOne; i++){
//                int fIndex = remainTwo.size() + i*3;
//                resultArray.addAll(remainOne.subList(fIndex, fIndex+3));
//            }
//        }
//        else if (addSubOfTwo) {
//            for (int i=0; i < loopOfRemainingTwo; i++){
//                int fIndex = remainOne.size() + i*3;
//                resultArray.addAll(remainTwo.subList(fIndex, fIndex+3));
//            }
//        }
//
//        resultArray.sort(Collections.reverseOrder());
//
//        String resStr = "";
//        for (Integer i:resultArray){
//            resStr = resStr + i.toString();
//        }
//        int retVal=0;
//        if(!resStr.isEmpty()){
//            retVal = Integer.parseInt(resStr);
//        }
//
//
//        return retVal;
//    }
//
//
//}
//*
//* */
//
//package org.example;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.HashSet;
//import java.util.List;
//
//public class Solution {
//
//    public static int solution(int n) {
//
//        List<HashSet<Integer>> staircases = new ArrayList<HashSet<Integer>>();
//        HashSet<Integer> tempHS;
//        Integer steps;
//
//        for (int i=1; i<n;i++){
//            tempHS = new HashSet<Integer>();
//            steps = i;
//
//            tempHS.add();
//        }
//
//        staircases.add(tempHS);
//
//        return staircases.size();
//    }
//
//}