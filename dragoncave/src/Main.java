import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        startingText();
        startGame();
    }

        static void startGame() {
            Scanner scanny = new Scanner(System.in);
            int choice = scanny.nextInt();

            switch (choice)
                {
                    case 1:
                        System.out.print("\n You approach the cave..." +
                                "\n It is dark and spooky..." +
                                "\n A large dragon jumps out in front of you! He opens his jaws and.." +
                                "\n Gobbles you down in one bite!" +
                                "\n");

                    case 2:
                        System.out.print("\n You approach the cave..." +
                                "\n The dragon is surprised by such a beautiful creature." +
                                "\n It takes you back to its lair and offers a treasure," +
                                "\n a mighty glowing sword,..." +
                                "\n for your hands in marriage." +
                                "\n Do you accept?" +
                                "\n");
                        System.out.print("\n Please type 1 for Yes " +
                                "\n or 2 for No: ");
                        dragonProposal();
                        break;
                    case 3:
                        System.out.print("\n Thank you for playing!");
                        break;
                    default:
                        System.out.println("\n Please select 1 or 2. Type 3 if you wants to exit");
                        startGame();
                }

        }
        static void dragonProposal() {
            Scanner scanny = new Scanner(System.in);
            int choice = scanny.nextInt();

            switch(choice) {
                case 1:
                    System.out.print("\n You answered yes. You turned down the mighty glowing sword" +
                            "\n that the dragon offers you as true love is not bounded by bribery." +
                            "\n You and the dragon lives happily ever after" +
                            "\n");
                    break;
                case 2:
                    System.out.print("\n You answered no. You snatch the mighty glowing sword " +
                            "\n out of its hand and slayed the foul beast for such offering." +
                            "\n Remorse by your action, you cried for 2 hours until you became thirsty" +
                            "\n You take a sip out of a fountain in the dragon's lair and poof..." +
                            "\n You sees yourself as a large scaly beast in the reflection of the fountain" +
                            "\n");
                    break;
                case 3:
                    startingText();
                    startGame();
                    break;
                default:
                    System.out.println("Please select 1 or 2. Type 3 if you want to return to previous menu");
                    dragonProposal();
            }
    }

    static void startingText() {
        System.out.print("...Welcome traveller. You are in a land full of dragons." +
                "\n In front of you, you see two caves. In one cave, the dragon is friendly" +
                "\n and will share his treasure with you. The other dragon is greedy and hungry" +
                "\n and will eat you on sight. Which cave will you go into? (1 or 2): ");
    }
}
