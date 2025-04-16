package com.pluralsight;

import java.util.Scanner;

public class Calculator2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //the inputs
        System.out.print("deposit amount: $");
        double principal = scanner.nextDouble();
        // gets the rate and converts it into decimal
        System.out.print("What Is Your Interest Rate: ");
        double annualRate = scanner.nextDouble() / 100;

        System.out.print("how Long Is Your Loan (IN YEARS): ");
        int years = scanner.nextInt();

        // daily details
        int daysPerYear = 365;

        //Calculations
        double futureValue = principal * Math.pow(1 + (annualRate / daysPerYear), daysPerYear * years);
        double totalInterest = futureValue - principal;

        //output answers
        System.out.printf("Future Value: $%.2f%n", futureValue);
        System.out.printf("Total Interest Earned: $%.2f%n", totalInterest);
    }
}
