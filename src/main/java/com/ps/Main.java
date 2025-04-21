package com.ps;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void displayHomeScreen() {
        System.out.println("HOME SCREEN");
        System.out.println("1: Show Available Books");
        System.out.println("2: Show Checked Out Books");
        System.out.println("0: Exit");
        System.out.print("Select one of the options: ");
    }

    public static void showAvailableBooks(Book[] books) {
        for (int i = 0; i < books.length; i++) {
            if (!books[i].isCheckedOut()) {
                System.out.println("Book ID: " + books[i].getId() + "   ISBN: " + books[i].getIsbn() + "   Title: " + books[i].getTitle());
            }
        }
    }

    public static void showCheckedOutBooks(Book[] books) {
        for (int i = 0; i < books.length; i++) {
            if (books[i].isCheckedOut()) {
                System.out.println("Book ID: " + books[i].getId() + "   ISBN: " + books[i].getIsbn() + "   Title: " + books[i].getTitle() + "   Name: " + books[i].getCheckedOutTo());
            }
        }
    }

    public static void main(String[] args) {

        Book[] books = new Book[20];
        books[0] = new Book(1, "978-1649374042", "Fourth Wing", true, "Angel");
        books[1] = new Book(2, "978-1649374172", "Iron Flame", false, "");
        books[2] = new Book(3, "978-1649377159", "Onyx Storm", true, "Maria");
        books[3] = new Book(4, "978-1619634442", "A Court of Thorns and Roses", true, "Raquel");
        books[4] = new Book(5, "978-1619634466", "A Court of Mist and Fury", false, "");
        books[5] = new Book(6, "978-1619634480", "A Court of Wings and Ruin", true, "Brianna");
        books[6] = new Book(7, "978-1681196312", "A Court of Frost and Starlight", false, "");
        books[7] = new Book(8, "978-1681196282", "A Court of Silver Flames", false, "");
        books[8] = new Book(9, "978-1668085721", "Spark of the Everflame", false, "");
        books[9] = new Book(10, "978-1668086759", "Glow of the Everflame", true, "Sevasti");
        books[10] = new Book(11, "978-0345539786", "Red Rising", true, "Katerina");
        books[11] = new Book(12, "978-0345539793", "Golden Son", true, "Marcos");
        books[12] = new Book(13, "978-0345539809", "Morning Star", false, "");
        books[13] = new Book(14, "978-0399177868", "Iron Gold", false, "");
        books[14] = new Book(15, "978-0399177875", "Dark Age", false, "");
        books[15] = new Book(16, "978-0593871522", "Light Bringer", false, "");
        books[16] = new Book(17, "978-0062878083", "Gods & Monsters", false, "");
        books[17] = new Book(18, "978-0316536036", "The Cruel Prince", true, "Alejandra");
        books[18] = new Book(19, "978-0063031326", "Daughter of the Moon Goddess", true, "Olsi");
        books[19] = new Book(20, "978-0062891501", "Kingdom of the Cursed", false, "");

        System.out.println("Welcome to the Neighborhood Library!\n");
        displayHomeScreen();
        int menuGivenCommand = scanner.nextInt();
        System.out.println("You have selected: " + menuGivenCommand);
        System.out.println();

        if (menuGivenCommand == 1) {
            System.out.println("AVAILABLE BOOKS");
            showAvailableBooks(books);

            System.out.println("\n1: select book to check out");
            System.out.println("2: exit to home screen");
            System.out.print("Select one of the options: ");
            int availableBooksGivenCommand = scanner.nextInt();
            System.out.println();


            if (availableBooksGivenCommand == 1) {
                System.out.print("Please enter the ID of the book you'd like to check out: ");
                int bookIdToCheckOut = scanner.nextInt();
                scanner.nextLine();
                int BookIndexToCheckOut = bookIdToCheckOut - 1;

                System.out.print("Please enter your first name: ");
                String userName = scanner.nextLine();

                boolean bookToCheckOutFound = false;
                for (int i = 0; i < books.length; i++) {
                    if (!books[BookIndexToCheckOut].isCheckedOut() && books[i].getId() == bookIdToCheckOut) {
                        books[i].setCheckedOut(true);
                        books[i].setCheckedOutTo(userName);
                        System.out.println("You have checked out: " + books[i].getTitle());
                        bookToCheckOutFound = true;
                        break;
                    }
                }
                if (!bookToCheckOutFound){
                    System.out.println("This ID does not match any of the books");
                }
            }
            else if (availableBooksGivenCommand == 2){
                System.out.println("You have selected to go back to home screen");
            }
            else {
                System.out.println("invalid command");
            }
        }


            else if (menuGivenCommand == 2) {
                System.out.println("CHECKED OUT BOOKS");

                showCheckedOutBooks(books);
                System.out.println("\n1: check in a book");
                System.out.println("2: exit to home screen");
                System.out.print("Select one of the options: ");
                int checkedOutBooksCommand = scanner.nextInt();

                System.out.println();


                if(checkedOutBooksCommand == 1){

                    System.out.print("Please enter the ID of the book you'd like to check in: ");
                    int bookIdToCheckIn = scanner.nextInt();
                    int bookIndexToCheckIn = bookIdToCheckIn - 1;

                    boolean bookToCheckInFound = false;
                    for (int i = 0; i < books.length; i++) {
                        if (books[bookIndexToCheckIn].isCheckedOut() && books[i].getId() == bookIdToCheckIn) {
                            books[i].setCheckedOut(false);
                            books[i].setCheckedOutTo("");
                            System.out.println("You have checked in: " + books[i].getTitle());
                            bookToCheckInFound =true;
                            break;
                        }
                    }
                    if (!bookToCheckInFound){
                        System.out.println("This ID does not match any of the books");
                    }

                }

                else if (checkedOutBooksCommand == 2){
                    System.out.println("You have selected to go back to home screen");
                }
                else {
                    System.out.println("invalid command");
                }
            }

            else if(menuGivenCommand == 0){
            System.out.println("Thank you for visiting the Neighborhood Library!\nGoodbye");
        }

            else{
            System.out.println("invalid selection \nPlease try again\n");
        }
    }
}