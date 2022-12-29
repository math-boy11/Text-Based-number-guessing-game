package com.theo.guessingGame;

import java.util.Scanner;

public class Main {

    private static Integer number;
    private static Integer numberOfGuessesLeft = 5;
    private static Integer maxNumber = 10;

    public static void main(String[] args) {
        //Generate a random number
        RandomGenerator r = new RandomGenerator();
        number = r.generateInt(1, maxNumber);

        //Welcome the user
        System.out.println("Welcome to the number guessing game! You have " + numberOfGuessesLeft + " guesses to guess the number from 1 to " + maxNumber +"!");
        //Ask the user
        ask();
    }

    public static void ask() {

        if (numberOfGuessesLeft == 0) {
            System.out.println("You Lose! The number was " + number + ". You had " + numberOfGuessesLeft + " guesses left.");
            System.exit(0);
        }

        System.out.println("Whats your guess?");
        Scanner in = new Scanner(System.in);
        String userChoice = in.nextLine();
        Integer userChoiceInt = Integer.parseInt(userChoice);

        numberOfGuessesLeft--;

        if (tooHigh(userChoiceInt) == true) {
            System.out.println("Too High!");
            System.out.println("You have " + numberOfGuessesLeft + " guesses left!");
            ask();
        } else if (tooLow((userChoiceInt)) == true) {
            System.out.println("Too Low!");
            System.out.println("You have " + numberOfGuessesLeft + " guesses left!");
            ask();
        } else {
            System.out.println("You Won! The number was " + number + ". You had " + numberOfGuessesLeft + " guesses left.");
        }
    }

    public static Boolean tooHigh(Integer choice) {
        if (choice > number) {
            return true;

        } else {
            return false;
        }
    }
    public static Boolean tooLow(Integer choice) {
        if (choice < number) {
            return true;

        } else {
            return false;
        }
    }
}
