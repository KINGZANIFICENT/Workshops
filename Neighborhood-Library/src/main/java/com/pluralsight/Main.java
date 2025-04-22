package com.pluralsight;

import java.util.Scanner;

public class Main {
    // make array of 20 books
    static Book[] myBooks = new Book[20];
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        makeBooks(); // call method
        showMenu(); // show the menu
    }
     // make 20 books
     // make 20 BMW-themed books
     static void makeBooks() {
         String[] bmwModels = {
                 "BMW 3 Series", "BMW 5 Series", "BMW 7 Series", "BMW X1", "BMW X3",
                 "BMW X5", "BMW X6", "BMW X7", "BMW M3", "BMW M4",
                 "BMW M5", "BMW Z4", "BMW i3", "BMW i4", "BMW i7",
                 "BMW iX", "BMW 8 Series", "BMW M2", "BMW 1 Series", "BMW Alpina B7"
         };

         for (int i = 0; i < myBooks.length; i++) {
             myBooks[i] = new Book(
                     i + 1,
                     "BMWISBN" + (1000 + i),
                     "The Story of the " + bmwModels[i]
             );
         }
     }

    // main menu
    static void showMenu() {
        boolean keepGoing = true;
        while (keepGoing) {
            System.out.println("Welcome to the Angels Library!");
            System.out.println("1. Checkout Books");
            System.out.println("2. View Checked Out Books");
            System.out.println("3. Exit Program");
            System.out.print("Pick option: ");
            String choice = input.nextLine();

            if (choice.equals("1")) {
                showAvailable();
            } else if (choice.equals("2")) {
                showCheckedOut();
            } else if (choice.equals("3")) {
                System.out.println("Bye!");
                keepGoing = false;
            } else {
                System.out.println("That wasn't a choice. Try again.");
            }
        }
    }
    // self explanatory
    static void showAvailable() {
        System.out.println("Here are the books you can check out:");
        boolean any = false;

        for (int i = 0; i < myBooks.length; i++) {
            if (!myBooks[i].getIsCheckedOut()) {
                System.out.println("ID: " + myBooks[i].getId() + ", ISBN: " + myBooks[i].getIsbn() + ", Title: " + myBooks[i].getTitle());
                any = true;
            }
        }

        if (!any) {
            System.out.println("Nothing is available right now.");
            return;
        }
        // self explanatory
        System.out.print("Type the ID of the book to check out (or X to go back): ");
        String answer = input.nextLine();

        if (!answer.equalsIgnoreCase("X")) {
            try {
                int bookId = Integer.parseInt(answer);
                Book foundBook = findBook(bookId);
                if (foundBook != null && !foundBook.getIsCheckedOut()) {
                    System.out.print("What is your name? ");
                    String name = input.nextLine();
                    foundBook.checkOut(name);
                    System.out.println("You got the book!");
                } else {
                    System.out.println("That book can't be checked out.");
                }
            } catch (Exception e) {
                System.out.println("Something went wrong TRY AGAIN.");
            }
        }
    }
    // self explanatory
    static void showCheckedOut() {
        System.out.println("Checked out books:");
        boolean any = false;

        for (int i = 0; i < myBooks.length; i++) {
            if (myBooks[i].getIsCheckedOut()) {
                System.out.println("ID: " + myBooks[i].getId() + ", ISBN: " + myBooks[i].getIsbn() + ", Title: " + myBooks[i].getTitle() + ", Borrower: " + myBooks[i].getCheckedOutTo());
                any = true;
            }
        }

        if (!any) {
            System.out.println("No books are checked out.");
            return;
        }

        System.out.print("Type C to return a book or X to go back: ");
        String choice = input.nextLine();

        if (choice.equalsIgnoreCase("C")) {
            System.out.print("Enter the ID of the book you want to return: ");
            try {
                int bookId = Integer.parseInt(input.nextLine());
                Book foundBook = findBook(bookId);
                if (foundBook != null && foundBook.getIsCheckedOut()) {
                    foundBook.checkIn();
                    System.out.println("Thanks for returning the book!");
                } else {
                    System.out.println("That book can't be returned.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input.");
            }
        }
    }

    static Book findBook(int id) {
        for (int i = 0; i < myBooks.length; i++) {
            if (myBooks[i].getId() == id) {
                return myBooks[i];
            }
        }
        return null;
    }
}



