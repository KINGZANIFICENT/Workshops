package com.pluralsight;


import java.util.Scanner;

public class Calculator1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //the inputs
        System.out.print("What Is Your Loan Amount: ");
        double principal = scanner.nextDouble();

        System.out.print("What Is Your Interest Rate");
        double annualRate = scanner.nextDouble() / 100;

        System.out.print("how Long Is Your Loan (IN YEARS)");
        int years = scanner.nextInt();

        // values
        int n = years * 12;
        double i = annualRate / 12;

        // Monthy Payment
        double numerator = i * Math.pow(1 + i, n);
        double denominator =  Math.pow(1 + i, n) - 1;
        double monthlyPayment = principal * (numerator / denominator);

        double Interest = (monthlyPayment * n) - principal;

//        output
        System.out.printf("Monthly Payment: $%.2f%n", + monthlyPayment);
        System.out.printf("Total Interest To Be Paid", + Interest);
    }
}