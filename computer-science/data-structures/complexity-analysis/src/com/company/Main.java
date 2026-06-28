package com.company;
import com.company.runner.*;


public class Main {

    public static void main(String[] args) {
        System.out.println("===== O(1) =====");
        ConstantRunner.run();

        System.out.println("===== O(2^n) =====");
        ExponentialTimeRunner.run();

        System.out.println("===== O(n!) =====");
        FactorialTimeRunner.run();

        System.out.println("===== O(n log n) =====");
        LinearithmicTimeRunner.run();

        System.out.println("===== O(n) =====");
        LinearRunner.run();

        System.out.println("===== O(log n) =====");
        LogarithmicTimeRunner.run();

        System.out.println("===== O(n^2) =====");
        QuadraticTimeRunner.run();


    }

}