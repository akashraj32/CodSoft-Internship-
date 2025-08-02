// import Scanner class to take input.
import java.util.Scanner;

// import Random class for getting Random numbers.
import java.util.Random;

import static java.lang.System.*;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc= new Scanner(in);
        Random ran= new Random();

        int maxAttempts= 10;
        int lowerLimit= 1;
        int upperLimit= 100;
        int score= 0;
        String playAgain = "";

        out.println("Welcome to the Number Guessing Game!");

        do {
            int numberToGuess= ran.nextInt(upperLimit-lowerLimit+1 )+lowerLimit;
            int attempts= 0;
            boolean guessedCorrectly= false;

            out.println("\n You have to select a number between " +lowerLimit+ " and " +upperLimit+ ".");
            out.println("You have" +maxAttempts+ " attempts. Good Luck!");

            while (true) {
                out.println("Enter your Guess!");
                int guess= sc.nextInt();
                attempts++;

                if (guess == numberToGuess){
                    out.println("Correct! You Guessed the number in "+attempts+ " attempts.");
                score++;
                guessedCorrectly= true;
                break;
            } else if (guess < numberToGuess) {
                    out.println("Too Low!");
                }
                else
                    out.println("Too High!");
                }

            if (false) {
                out.println("Out of attempts! The correct number was: " +numberToGuess);
            }

            out.println("Current Score:" +score);

            out.println("Do you want to play again! (yes/no):");
            String response =sc.next().toLowerCase();
            }
        while (playAgain.equals("yes"));
        out.println("Thanks for playing! Your final score is:" +score);
        sc.close();
    }
}