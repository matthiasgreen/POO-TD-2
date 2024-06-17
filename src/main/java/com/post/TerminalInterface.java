package com.post;

import java.util.Scanner;
import java.util.stream.Collectors;
import com.post.calculator.Calculator;
import com.post.calculator.Destination;
import com.post.calculator.Parcel;

class TerminalInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome to the Parcel Calculator Terminal Interface!");
            System.out.println("Please select an option:");
            System.out.println("1. Calculate the price of a parcel");
            System.out.println("2. Exit");

            // Get user input
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    calculateParcelPrice(scanner);
                    break;
                case 2:
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static int getInputWithinBounds(int lowerBound, int upperBound, Scanner scanner, String message) {
        int input;
        do {
            System.out.println(message);
            input = scanner.nextInt();
        } while (input < lowerBound || input > upperBound);
        return input;
    }

    private static int getInputWithinBounds(int lowerBound, Scanner scanner, String message) {
        return getInputWithinBounds(lowerBound, Integer.MAX_VALUE, scanner, message);
    }

    private static void calculateParcelPrice(Scanner scanner) {
        int[] dimensions = new int[3];
        dimensions[0] = getInputWithinBounds(1, scanner, "Please enter the height of the parcel in cm:");
        dimensions[1] = getInputWithinBounds(1, scanner, "Please enter the width of the parcel in cm:");
        dimensions[2] = getInputWithinBounds(1, scanner, "Please enter the length of the parcel in cm:");

        int weight = getInputWithinBounds(1, scanner, "Please enter the weight of the parcel in grams:");

        // Get list of destination codes to present to the user
        Destination[] destinations = Destination.values();
        String[] destinationCodes = new String[destinations.length];
        for (int i = 0; i < destinations.length; i++) {
            destinationCodes[i] = destinations[i].getCode() + " - " + Integer.toString(i + 1);
        }
        String destinationOptions = String.join(", ", destinationCodes);
        int destinationIndex = getInputWithinBounds(
            1, destinations.length, scanner,
            "Please select the destination of the parcel by entering the corresponding number: " + destinationOptions
        ) - 1;
        Destination destination = destinations[destinationIndex];
        
        Parcel parcel = new Parcel(dimensions, weight);
        float result = Calculator.calculatePrice(parcel, destination);
        System.out.printf("The price of shipping the parcel is: %.2f€.%n", result);
    }
}