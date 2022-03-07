import java.util.ArrayList;

public class Goblin {

    private int health = 20;
    private int strength = 10;
    private int intelligence = 5;
    private int speed = 1;

    public int getHealth() {
        return health;
    }

    public int getStrength() {
        return strength;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getSpeed() {
        return speed;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Goblin{" +
                "health=" + health +
                ", strength=" + strength +
                ", intelligence=" + intelligence +
                ", speed=" + speed +
                '}';
    }


    public static String drops() {
        ArrayList dropItems = new ArrayList();
        dropItems.add("leather vest");
        dropItems.add("rusty dagger");
        dropItems.add("broken helmet");
        dropItems.add("Goblin eyeball");
        dropItems.add("smelly boots");

        String loot = (String) dropItems.get(getRandomNumber(5,1));
        return loot;

        //pull a random loot
    }

    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);

        //generate random number, steal from hangman project
    }
}
