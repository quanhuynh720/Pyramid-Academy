import java.util.InputMismatchException;
import java.util.Scanner;

public class GuessGame {

    public int tries = 6;

    //JUnit testing
    public int getTries() {
        return tries;
    }

    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public static String greeting(String name) {
        return "\n Well, " + name + ", I am thinking of a number between 1 and 20. " +
                "\n Please take a guess. ";
    }

    static void guessGame() {

        Scanner scanny = new Scanner(System.in);

        int i;
        int tries = 6;
        int guess = 0; //need to define outside for try/catch scope
        String name = ""; //need to define outside for try/catch scope

        int randomNum = getRandomNumber(1,20);

        System.out.print("\n Hello! What is your name? ");
        try {
            name = scanny.nextLine();
        } catch (InputMismatchException e) {
            System.out.print("Please type a name");
        }

//        System.out.print("\n Well, " + name + ", I am thinking of a number between 1 and 20." +
//                "\n Please take a guess. ");
//removes above lines into separate method for JUnit testing
        System.out.print(greeting(name));

        for (i = 0; i < 6; i++) {
            try {
                guess = scanny.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("\n Please input a number between 1 and 20");
            }

            if ( guess == randomNum) {
                System.out.print("\n Great job, " + name + ", You guess my number in " + i + " guesses! ");
                break;
            } else if (guess > randomNum && guess <=20 && guess >= 1) {
                System.out.print("\n Your guess is too high. Guess again ");
            } else if (guess < randomNum && guess <=20 && guess >= 1 ) {
                System.out.print("\n Your guess is too low. Guess again ");
            } //the catch/try block takes care of the else statement
        }
        int choice = 0;
        if (i == tries) {
            System.out.print("\n You've ran out of tries." +
                    " The number was " + randomNum +
                    "\n Would you like to play again with a new number to guess? " +
                    "\n Please type 1 for Yes or 2 for No: ");
            try {
                choice = scanny.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("\n Please select either option 1 or 2");
            }
            if (choice == 1) {
                guessGame();
            } else if (choice == 2) {
                System.out.print("\n Thank you for playing!");
            }
        }
    }

}
