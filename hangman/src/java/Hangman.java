import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Hangman {

        public static int guess = 0;
        private static ArrayList missedLetters = new ArrayList<>();
        private static String dashes = "___";
        private static String word = hangWord();

    static void playHangman() {
        Scanner scanny = new Scanner(System.in);
        char letter = 'c';

        System.out.print("\n H A N G M A N" +
                "\n +---+" +
                "\n     |" +
                "\n     |" +
                "\n     |" +
                "\n    ===" +
                "\n Missed letters: " +
                "\n ___" +
                "\n Guess a letter: ");


            while (guess != 7) {
                try {
                    letter = scanny.next().charAt(0); //get char from scanner
                } catch (InputMismatchException e) {
                    System.out.print("Please input a letter.");
                }

                if (missedLetters.contains(letter)) {
                    System.out.print("You have already guessed that letter. Choose again. ");

                } else if (word.indexOf(letter) == -1) {
                    missedLetters.add(letter);
                    guess++;
                    hangmanSteve();

                } else if (word.indexOf(letter) != -1) { //replace dashes with the correct guess letter

                    int index = word.indexOf(letter); //grab the letter index of the hangWord
                    StringBuilder sb = new StringBuilder(dashes);
                    sb.setCharAt(index, letter); //replace the dash with letter
                    dashes = sb.toString(); //convert sb back to string

                    System.out.print("\n You guessed a correct letter! " +
                            "\n Guess again: ");
                }

                int choice = 0;
                if (dashes.equals(word)) {
                    System.out.print("\n Congratulations! The secret word is, " + word + ", You have won!" +
                            "\n Would you like to play again? (Type 1 for yes or 2 for no) ");
                    try {
                        choice = scanny.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.print("\n Please select either option 1 or 2");
                    }
                    if (choice == 1) {
                        guess = 0; //clear tries
                        missedLetters.clear(); //clear guessed letters
                        playHangman();
                    } else if (choice == 2) {
                    }
                }

            }

    }

    public static String hangWord(){
        ArrayList list = new ArrayList();
        list.add("dog");
        list.add("cat");
        list.add("pig");
        list.add("eat");
        list.add("ink");
        list.add("fig");
        list.add("hat");
        list.add("jug");
        list.add("sit");
        list.add("tag");
        list.add("urn");
        list.add("war");
        list.add("van");
        list.add("kit");
        list.add("may");

        String word = (String) list.get(getRandomNumber(15,1));
        return word;

        //pull a random word from list
    }

    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);

        //generate random number, steal from hangman project
    }

    public static void hangmanSteve() {
        if (guess == 1) {
            System.out.print("\n H A N G M A N" +
                    "\n +---+" +
                    "\n    O|" +
                    "\n     |" +
                    "\n     |" +
                    "\n    ===" +
                    "\n Missed letters: " + missedLetters +
                    "\n " + dashes +
                    "\n Guess a letter: ");
        } else if (guess == 2) {
            System.out.print("\n H A N G M A N" +
                    "\n +---+" +
                    "\n    O|" +
                    "\n    ||" +
                    "\n     |" +
                    "\n    ===" +
                    "\n Missed letters: " + missedLetters +
                    "\n " + dashes +
                    "\n Guess a letter: ");
        } else if (guess == 3) {
            System.out.print("\n H A N G M A N" +
                    "\n +---+" +
                    "\n    O|" +
                    "\n    ||" +
                    "\n     |" +
                    "\n    ===" +
                    "\n Missed letters: " + missedLetters +
                    "\n " + dashes +
                    "\n Guess a letter: ");
        } else if (guess == 4) {
            System.out.print("\n H A N G M A N" +
                    "\n +---+" +
                    "\n    O|" +
                    "\n    ||" +
                    "\n   / |" +
                    "\n    ===" +
                    "\n Missed letters: " + missedLetters +
                    "\n " + dashes +
                    "\n Guess a letter: ");
        } else if (guess == 5) {
            System.out.print("\n H A N G M A N" +
                    "\n +---+" +
                    "\n    O |" +
                    "\n    | |" +
                    "\n   / \\|" +
                    "\n    ===" +
                    "\n Missed letters: " + missedLetters +
                    "\n " + dashes +
                    "\n Guess a letter: ");
        } else if (guess == 6) {
            System.out.print("\n H A N G M A N" +
                    "\n +---+" +
                    "\n   O  |" +
                    "\n   |/ |" +
                    "\n  / \\ |" +
                    "\n    ===" +
                    "\n Missed letters: " + missedLetters +
                    "\n " + dashes +
                    "\n Guess a letter: ");
        } else if (guess == 7) {
            System.out.print("\n H A N G M A N" +
                    "\n +---+" +
                    "\n   O  |" +
                    "\n  \\|/ |" +
                    "\n  / \\ |" +
                    "\n    ===" +
                    "\n Missed letters: " + missedLetters +
                    "\n " + dashes +
                    "\n You've ran out of tries." +
                    "\n The word was: " + word +
                    "\n") ;
        }
    }

    public int getGuess() { //JUnit testing
        return guess;
    }
}
