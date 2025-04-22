package com.pluralsight;

import java.util.Scanner;

public class MainCalculatorSelector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which calculator would you like to use?");
        System.out.println(" 1) Loan Payment Calculator");
        System.out.println(" 2) Annuity Calculator");
        System.out.println(" 3) Future Value Calculator");
        System.out.print("Enter 1, 2 or 3: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        switch (choice) {
            case 1:
                Calculator1.main(new String[]{});
                break;
            case 2:
                Calculator2.main(new String[]{});
                break;
            case 3:
                Calculator3.main(new String[]{});
                break;
            default:
                System.out.println("Invalid selection. Exiting.");
        }
        scanner.close();
    }
}
