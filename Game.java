import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the guessing game!");

        int score = 0;
        int numOfRounds = 1;  // Default to 1 round if an exception occurs
        try {
            System.out.print("Choose the number of rounds you want to guess: ");
            numOfRounds = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Defaulting to 1 round.");
            input.next(); // Clear invalid input
        }

        System.out.println("Number of rounds: " + numOfRounds);

        for (int i = 0; i < numOfRounds; i++) {
            int targetNumber = generateRandom();
            boolean validInput = false;

            while (!validInput) {
                System.out.print("Guess a number between 1 and 100: " + "(THE NUMBER IS : "+targetNumber+" ) ");
                try {
                    int userGuess = input.nextInt();
                    if (userGuess < 1 || userGuess > 100) {
                        System.out.println("Please enter a number between 1 and 100.");
                    } else {
                        validInput = true; // valid input
                        if (userGuess > targetNumber) {
                            System.out.println("Too high! Try again.");
                        } else if (userGuess < targetNumber) {
                            System.out.println("Too low! Try again.");
                        } else {
                            System.out.println("Correct! You've guessed the number.");
                            score++;
                        }
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input! Please enter a number.");
                    input.next(); // Clear invalid input
                }
            }
        }

        System.out.println("Game over! Your score is: " + score);
    }

    public static int generateRandom() {
        return (int) (Math.random() * 100) + 1;
    }
}
