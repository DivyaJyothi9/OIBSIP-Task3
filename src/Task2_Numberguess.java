import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Task2_Numberguess {
    private static final int Min_Range = 1;
    private static final int Max_Range = 100;
    private static final int Max_Attempts = 10;
    private static final int Max_Rounds = 3;

    public static void main(String[] args) {
        Random random = new Random();

        // Scanner scanner = new Scanner(System.in);
        //int totalScore = 0;

        System.out.println("NUMBER GUESSING GAME");
        System.out.println("Total Number Of ROUNDS:" + Max_Rounds);
        System.out.println("Attempts to guess number in each round:" + Max_Attempts + "\n");

        int totalScore = 0;

        try (Scanner scanner = new Scanner(System.in)) {
            for (int i = 1; i <= Max_Rounds; i++) {
                int number = random.nextInt(Max_Range - Min_Range + 1) + Min_Range;
                int attempts = 0;

                System.out.printf("Round %d: Guess the number between %d and %d in %d attempts.\n", i, Min_Range, Max_Range, Max_Attempts);


                while (attempts < Max_Attempts) {
                    System.out.print("Enter your guess number: ");

                    try {
                        if (scanner.hasNextInt()) {
                            int guessNumber = scanner.nextInt();
                            attempts++;

                            if (guessNumber == number) {
                                int score = Max_Attempts - attempts;
                                totalScore = totalScore + score;
                                System.out.printf("Exactly! Number Guessed Correctly. Attempts = %d and Round Score =%d\n", attempts, score);
                                break;
                            } else if (guessNumber < number) {
                                System.out.printf("Number is greater than %d. Attempts remained = %d.\n", guessNumber, Max_Attempts - attempts);
                            } else {
                                System.out.printf("Number is lesser than %d. Attempts remained = %d.\n", guessNumber, Max_Attempts - attempts);
                            }
                        } else {
                            System.out.println("Invalid input!! Please enter a valid integer.");
                            scanner.next();
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input!! Please enter a valid integer.");
                        scanner.next();
                    }
                }
                if (attempts == Max_Attempts) {
                    System.out.printf("\nRound = %d\nAttempts = 0\nThe Random Number is : %d\n\n", i, number);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.printf("Game finished. Total Score = %d\n", totalScore);
    }
}


