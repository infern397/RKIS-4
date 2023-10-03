package org.example.fourthLab;

import java.util.Scanner;

/**
 * This class provides utility methods for getting various types of user input from the console.
 */
public class Input {
    /**
     * Get an integer input from the user.
     *
     * @return The integer value entered by the user.
     */
    public static int getIntInput() {
        Scanner scanner = new Scanner(System.in);
        int result = 0;
        boolean validInput = false;

        while (!validInput) {
            String input = scanner.nextLine().trim();
            try {
                result = Integer.parseInt(input);
                validInput = true;
            } catch (NumberFormatException e) {
                System.err.println("Invalid input. Please enter an integer.");
            }
        }
        return result;
    }

    /**
     * Get a floating-point number input from the user.
     *
     * @return The floating-point number entered by the user.
     */
    public static float getFloatInput() {
        Scanner scanner = new Scanner(System.in);
        float result = 0.0f;
        boolean validInput = false;

        while (!validInput) {
            String input = scanner.nextLine().trim();
            try {
                result = Float.parseFloat(input);
                validInput = true;
            } catch (NumberFormatException e) {
                System.err.println("Invalid input. Please enter a floating-point number.");
            }
        }
        return result;
    }

    /**
     * Get a non-empty string input from the user.
     *
     * @return The non-empty string entered by the user.
     */
    public static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        String input = null;
        while (input == null || input.trim().isEmpty()) {
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.err.println("Invalid input. Please enter a value.");
            }
        }
        return input;
    }
}