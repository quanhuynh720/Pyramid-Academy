import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        guessGame();
    }

    static void guessGame() {

        Scanner scanny = new Scanner(System.in);

        int i;
        int tries = 6;

        Random random = new Random(); //random instance
        int max = 21; //max value -1
        int randomNum = random.nextInt(max); //actual random num

        System.out.print("\n Hello! What is your name? ");
        String name = scanny.nextLine();

        System.out.print("\n Well, " + name + ", I am thinking of a number between 1 and 20." +
                "\n Please take a guess. ");

        for (i = 0; i < 6; i++) {

            int guess = scanny.nextInt();

            if (guess == randomNum) {
                System.out.print("\n Great job, " + name + ", You guess my number in " + i+1 + " guesses!");
                break;
            } else if (guess > randomNum) {
                System.out.print("\n Your guess is too high. Guess again ");
            } else if (guess < randomNum) {
                System.out.print("\n Your guess is too low. Guess again ");
            } else {
                System.out.print("\n Please guess a number. This counts as a try. ");
            }
        }
        if (i == tries) {
            System.out.print("\n You've ran out of tries." +
                    " The number was " + randomNum +
                    "\n Would you like to play again with a new number to guess? " +
                    "\n Please type 1 for Yes or 2 for No: ");
                int choice = scanny.nextInt();
                if (choice == 1) {
                    guessGame();
                } else if (choice == 2) {
                    System.out.print("Thank you for playing!");
                }
        }
    }
}
