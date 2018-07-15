package com.java.codechef.contests;

/**
 *
 * You are asked to calculate factorials of some small positive integers.
 *
 * Input
 * An integer t, 1<=t<=100, denoting the number of testcases, followed by t lines, each containing a single integer n, 1<=n<=100.
 *
 * Output
 * For each integer n given at input, display a line with the value of n!
 *
 * Example
 * Sample input:
 * 4
 * 1
 * 2
 * 5
 * 3
 * Sample output:
 *
 * 1
 * 2
 * 120
 * 6
 *
 */

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Factorial2 {

    static BigInteger factorial(int n) {
        BigInteger f = new BigInteger("1");
        for(int i = 2; i <= n; i++) {
            f = f.multiply(BigInteger.valueOf(i));
        }
        return f;
    }

    public static void main(String args[]) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        List<BigInteger> fact = new ArrayList<>();
        for(int i=1; i<=t; i++) {
            int n = sc.nextInt();
            fact.add(factorial(n));
        }

        for(BigInteger f: fact) {
            System.out.println(f);
        }
    }
}
