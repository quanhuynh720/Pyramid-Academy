import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Land {

    private String terrain = "forrest";
    private static String[][] mapGrid = new String[5][5];
    static int[] location = new int[2];
    static int[] newLocation = new int[2];

    static Goblin goblin = new Goblin();
    static Human human = new Human();



    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);

        //generate random number, steal from hangman project
    }

    public static void loadGoblinIntoGrid() {
        int counter = 0;
            while (counter < 5) { //load 5 random goblins
                int randRow = getRandomNumber(1, 5);
                int randColumn = getRandomNumber(1, 5);
                if (mapGrid[randRow][randColumn] == null) {
                    mapGrid[randRow][randColumn] = "X";
                    ++counter;
                }
            }
//        for (String[] print : mapGrid) {
//            System.out.println(Arrays.toString(print));
//        }
        reprintMap();
    }

    public static void loadHumanIntoGrid() { //load human first and then goblin to see print grid
        int counter = 0;
        while (counter < 1) { //load one human
            int randRow = getRandomNumber(1, 5);
            int randColumn = getRandomNumber(1, 5);
            if (mapGrid[randRow][randColumn] == null) {
                mapGrid[randRow][randColumn] = "O";
                ++counter;
            }
        }
    }

    public static void movement() {
        findPlayer(); //dont take this out
        int row = location[0];
        int column = location[1];
        Scanner scanny = new Scanner(System.in);
        char move = 'x';
            System.out.print("\n Please select a movement (n, e, s, w):  ");

            try {
                move = scanny.next().charAt(0); //work if scan for char
            } catch (InputMismatchException e) {
                System.out.print("Please select a directon");
            }

            try {
                if (move == 'n') {
                    if (mapGrid[row - 1][column] == "X") {   //if the direction that the player wants to go to contains a goblin: 1) fight it. 2) move player to that direction after fight. 3) Null out player previous location
                        newLocation = new int[]{row - 1, column};
                        fight();
                    } else {
                        mapGrid[row - 1][column] = "O";
                        mapGrid[row][column] = null;
                        reprintMap();
                        movement();
                    }
                } else if (move == 'e') {
                    if (mapGrid[row][column + 1] == "X") {
                        newLocation = new int[]{row, column + 1};
                        fight();
                    } else {
                        mapGrid[row][column + 1] = "O";
                        mapGrid[row][column] = null;
                        reprintMap();
                        movement();
                    }
                } else if (move == 's') {
                    if (mapGrid[row + 1][column] == "X") {
                        newLocation = new int[]{row + 1, column};
                        fight();
                    } else {
                        mapGrid[row + 1][column] = "O";
                        mapGrid[row][column] = null;
                        reprintMap();
                        movement();
                    }
                } else if (move == 'w') {
                    if (mapGrid[row][column - 1] == "X") {
                        newLocation = new int[]{row, column - 1};
                        fight();
                    } else {
                        mapGrid[row][column - 1] = "O";
                        mapGrid[row][column] = null;
                        reprintMap();
                        movement();
                    }
                }
            } catch (Exception e) {
                System.out.print("\n Out of map boundaries! Please choose a different direction");
                movement();
            }
    }

    public static void findPlayer() {
        for ( int i = 0; i < 5; ++i ) {
            for ( int j = 0; j < 5; ++j ) {
                if ( mapGrid[i][j] == "O" ) {
                    location = new int[]{i, j};
                }
            }
        }
 //       System.out.println(Arrays.toString(location));
    }

    public static void reprintMap() {
        System.out.print("\n");
        for (String[] print : mapGrid) {
            System.out.println(Arrays.toString(print));
        }
    }

    public static void fight() {
        int humanDamage = (int)(Math.random() * 10) + 1; //damage = strength/2
        int goblinDamage = (int)(Math.random() * 5) + 1;

        for(int i = 0; i <= goblin.getHealth(); i++) {
            human.setHealth(human.getHealth() - goblinDamage);
            goblin.setHealth(goblin.getHealth() - humanDamage);
            if (human.getHealth() <= 0) {
                System.out.print("\n Your human have died in combat!" +
                        "\n GAME OVER");
            } else {
                System.out.print("\n You have killed a goblin! Congratulation mighty warrior.");
                System.out.print("\n You now have " + human.getHealth() + " HP left.");
                Human.receiveLoot();

                findPlayer();
                int row = location[0];
                int column = location[1];
                mapGrid[row][column] = null; //null out player previous location

                int newRow = newLocation[0];
                int newColumn = newLocation[1];
                mapGrid[newRow][newColumn] = "O"; //move player to chosen location after beating goblin

                reprintMap();
                movement();

            }
        }
    }

}
