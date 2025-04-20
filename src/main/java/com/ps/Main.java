package com.ps;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);


    public static void displayHomeScreen() {
        System.out.println("Home Screen");
        System.out.println("1: Show Available Books");
        System.out.println("2: Show Checked Out Books");
        System.out.println("0: Exit");
        System.out.print("Select one of the options: ");
    }

    public static void main(String[] args) {

        displayHomeScreen();
        int givenCommand = scanner.nextInt();

    }
}