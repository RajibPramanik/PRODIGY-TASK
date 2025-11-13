import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int numberToGuess = random.nextInt(100) + 1; // Random number between 1–100
        int userGuess = 0;
        int attempts = 0;

        System.out.println("🎯 Welcome to the Guessing Game!");
        System.out.println("I'm thinking of a number between 1 and 100.");

        // Loop until correct guess
        while (userGuess != numberToGuess) {
            System.out.print("Enter your guess: ");
            userGuess = sc.nextInt();
            attempts++;

            if (userGuess < numberToGuess) {
                System.out.println("Too low! Try again.");
            } else if (userGuess > numberToGuess) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("🎉 Congratulations! You guessed the number.");
                System.out.println("It took you " + attempts + " attempts.");
            }
        }

        sc.close();
    }
}
