package com.pluralsight;
import java.util.Scanner;
public class Calculator3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // the inputs
        System.out.print("Enter the monthly payout amount: $");
        double monthlyPayout = scanner.nextDouble();
        // gets the rate and converts it into decimal
        System.out.print("What Is Your interest rate: ");
        double annualRate = scanner.nextDouble() / 100;

        System.out.print("Enter The Number Of Years To Pay Out: ");
        int years = scanner.nextInt();

        // values
        double monthlyRate = annualRate / 12;
        int totalMonths = years * 12;

        // Calculations
        double presentValue = monthlyPayout * (1 - Math.pow(1 + monthlyRate, -totalMonths)) / monthlyRate;

        // Output answers
        System.out.printf("annual payouts is: $%.2f%n", presentValue);
    }
}