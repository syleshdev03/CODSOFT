import java.util.Scanner;
import java.util.Random;

public class Number_Guessing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        int score = 0;
        boolean playAgain = true;
        while (playAgain) {
            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("I have generated a random number between 1 and 100.");
            int randomNumber = rand.nextInt(100) + 1;
            int attempts = 0;
            while (true) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;
                if (guess == randomNumber) {
                    System.out.println("Congratulations! Your guess is correct!");
                    score++;
                    break;
                } else if (guess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
                if (attempts == 3) {
                    System.out.println("sorry!! You have reached the maximum number of attempts.");
                    System.out.println("The correct number was " + randomNumber);
                    break;
                }
            }
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();
            playAgain = playAgainInput.equals("yes");
        }
        System.out.println("Game over!");
        System.out.println("Your score is " + score);
    }
}