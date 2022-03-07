import java.util.ArrayList;

public class Human {

    private int health = 30;
    private int strength = 20;
    private int intelligence = 20;
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
        return "Human{" +
                "health=" + health +
                ", strength=" + strength +
                ", intelligence=" + intelligence +
                ", speed=" + speed +
                '}';
    }

    public static void receiveLoot() {
        ArrayList inventory = new ArrayList();
        inventory.add(Goblin.drops());
    }
}
