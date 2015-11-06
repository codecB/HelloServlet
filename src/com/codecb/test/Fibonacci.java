package com.codecb.test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.*;

public class Fibonacci {
    public static long count = 0;

    private static Map<Integer,Long> fibs = new HashMap<>();


    //Exponential, n up to 48
    public static long fib1(int n){
        count ++;
        long result;
        if(n == 1){
            result = 1;
        }else if(n == 2){
            result = 1;
        }else{
            result = fib1(n-1) + fib1(n-2);
        }

        return result;
    }

    //linear, n up to 1400
    public static long fib2(int n){
        Map<Integer,Long> fibs = new HashMap<>();
        return fib2recur(n,fibs);
    }

    private static long fib2recur(int n,Map<Integer,Long> fibs){
        count ++;
        long result;
        if(fibs.containsKey(n)){
            result = fibs.get(n);
        }else{
            if(n == 1){
                result = 1;
            }else if(n == 2){
                result = 1;
            }else{
                result = fib2recur(n - 1,fibs) + fib2recur(n - 2,fibs);
            }
        }
        fibs.put(n,result);
        return result;
    }

    //linear, uses BigInteger, n up to 100000
    public static BigInteger fib3(int n){
        Map<Integer,BigInteger> fibs = new HashMap<>();
        return fib3recur(n, fibs);
    }

    private static BigInteger fib3recur(int n,Map<Integer,BigInteger> fibs){
        count ++;
        BigInteger result;
        if(fibs.containsKey(n)){
            result = fibs.get(n);
        }else{
            if(n == 1){
                result = BigInteger.valueOf(1);
            }else if(n == 2){
                result = BigInteger.valueOf(1);
            }else{
                result = fib3recur(n - 1,fibs).add(fib3recur(n - 2,fibs));
            }
        }
        fibs.put(n,result);
        return result;
    }


    //uses stack, BigInteger, n up to ?
    public static BigInteger fib4(int n){
        List<BigInteger> fibStack = new LinkedList<>();

        BigInteger result;

        if(n == 1 || n == 2){
            result = BigInteger.valueOf(1);
        }else{
            BigInteger bi = BigInteger.valueOf(1);
            ((LinkedList<BigInteger>)fibStack).push(bi);
            ((LinkedList<BigInteger>)fibStack).push(bi);

            while ((n--)>2) {
                count ++;
                BigInteger second = ((LinkedList<BigInteger>) fibStack).pop();
                BigInteger first = ((LinkedList<BigInteger>) fibStack).pop();
                BigInteger sum = first.add(second);
                ((LinkedList<BigInteger>) fibStack).push(second);
                ((LinkedList<BigInteger>) fibStack).push(sum);
            }
            result = ((LinkedList<BigInteger>) fibStack).pop();

        }
        return result;

    }

    //does not use stack, performance is about the same as fib4
    public static BigInteger fib5(int n){
        BigInteger num1 = BigInteger.valueOf(1);
        BigInteger num2 = BigInteger.valueOf(1);

        BigInteger result = num2;

        while ((n--)>2) {
            count ++;
            result = num1.add(num2);
            num1 = num2;
            num2 = result;
        }
        return result;
    }


    public static BigInteger fib6(int n){

//        double phi = 1.618033989;
        BigDecimal phi = new BigDecimal(1.618033989);
        BigDecimal nphi = phi.negate().add(new BigDecimal(1));//1-phi
        BigDecimal mphi = phi.multiply(new BigDecimal(2)).subtract(new BigDecimal(1));//2*phi-1

        n--;
        BigDecimal result = (phi.pow(n+1).subtract(nphi.pow(n+1))).divide(mphi);
//        result = result.setScale(0, RoundingMode.HALF_UP);
        return result.toBigInteger();
    }



    public static void main(String[] args) {
//        System.out.println("Usage: java <classname> 100 3");
//        System.out.println("add argument -Xss10M if you get java.lang.StackOverflowError\n");

        int n = 10;
        int methodIndex = 6;
        if(args.length > 0){
            try {
                n = Integer.parseInt(args[0]);
            }catch(NumberFormatException e){
                System.out.println("The first argument must be an integer.");
                return;
            }

            if(args.length >1){
                try {
                    methodIndex = Integer.parseInt(args[1]);
                }catch(NumberFormatException e){
                    System.out.println("The second argument must be an integer.");
                    return;
                }
            }
        }

        long start = System.currentTimeMillis();

        if(methodIndex == 1){
            long result;
            result = fib1(n);
            System.out.println("Fibonacci "+n+" is: "+result);
        }else if(methodIndex == 2){
            long result;
            result = fib2(n);
            System.out.println("Fibonacci "+n+" is: "+result);
        }else if(methodIndex == 3){
            BigInteger bigResult = fib3(n);
            String output = NumberFormat.getNumberInstance(Locale.US).format(bigResult);
            System.out.println("Fibonacci "+n+" is: "+output);
        }else if(methodIndex == 4){
            BigInteger bigResult = fib4(n);
            String output = NumberFormat.getNumberInstance(Locale.US).format(bigResult);
            System.out.println("Fibonacci "+n+" is: "+output);
        }else if(methodIndex == 5){
            BigInteger bigResult = fib5(n);
            String output = NumberFormat.getNumberInstance(Locale.US).format(bigResult);
            System.out.println("Fibonacci "+n+" is: "+output);
        }else if(methodIndex == 6){
            BigInteger bigResult = fib6(n);
            String output = NumberFormat.getNumberInstance(Locale.US).format(bigResult);
            System.out.println("Fibonacci "+n+" is: "+output);
        }else{
            BigInteger bigResult = fib6(n);
            String output = NumberFormat.getNumberInstance(Locale.US).format(bigResult);
            System.out.println("Fibonacci "+n+" is: "+output);
        }

        long end = System.currentTimeMillis();



        long diff = (end-start);
        String time;

        if(diff < 1000){
            time = diff +" milliseconds";
        }else{
            time = diff/1000 +" seconds";
        }




        System.out.println("time = "+time+", count = "+count);


//        for (int i=1;i<31;i++){
//            count = 0;
//            fibs = new HashMap<>();
//            fib2(i);
////            System.out.println("n = "+i+", count =  "+count);
//            System.out.println(count);
//        }

    }
}
