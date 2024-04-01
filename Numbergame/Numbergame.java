import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1; // Minimum value of the range
        int maxRange = 100; // Maximum value of the range
        int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
        int attempts = 0;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I've selected a number between " + minRange + " and " + maxRange + ". Can you guess it?");

        boolean playAgain = true;
        while (playAgain) {
            int userGuess;
            boolean guessedCorrectly = false;

            while (!guessedCorrectly) {
                System.out.print("Enter your guess: ");
                userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed it right.");
                    guessedCorrectly = true;
                    score++;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low! Try a higher number.");
                } else {
                    System.out.println("Too high! Try a lower number.");
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();
            playAgain = playAgainInput.equals("yes");
            if (playAgain) {
                targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
                System.out.println("I've selected a new number. Let's play again!");
            }
        }

        System.out.println("Game over! Your score: " + score + " out of " + attempts + " attempts.");
        scanner.close();
    }
}