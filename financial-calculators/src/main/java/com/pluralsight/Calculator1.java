package com.pluralsight;

import java.util.Scanner;

public class Calculator1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // the inputs
        System.out.print("What Is Your Loan Amount: ");
        double principal = scanner.nextDouble();
        // gets the rate and converts it into decimal
        System.out.print("What Is Your Interest Rate (e.g. 5 for 5%): ");
        double annualRate = scanner.nextDouble() / 100.0;

        System.out.print("Enter The Number Of Years To Pay Out: ");
        int years = scanner.nextInt();

        // Calculations
        int n = years * 12;
        double monthlyRate = annualRate / 12.0;
        double numerator   = monthlyRate * Math.pow(1 + monthlyRate, n);
        double denominator = Math.pow(1 + monthlyRate, n) - 1;
        double monthlyPayment = principal * (numerator / denominator);
        double totalInterest   = (monthlyPayment * n) - principal;

        // output answers
        System.out.printf("Total Interest To Be Paid: $%.2f%n", totalInterest);
        System.out.printf("Monthly Payment:           $%.2f%n", monthlyPayment);
    }
}