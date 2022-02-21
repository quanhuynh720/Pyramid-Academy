public class Combat {
    static Goblin goblin = new Goblin();
    static Human human = new Human();

    public static void fight() {
        int damage = (int) (Math.random() * 9) + 1;
        int humanHealth = human.getHealth();
        human.setHealth(humanHealth - damage);

    while(goblin.getHealth() >=0 ) {
        if (human.getHealth() <= 0) {
            System.out.print("\n Your human have died in combat!");
        } else if (goblin.getHealth() <=0 ){
            System.out.print("\n You have killed a goblin! Congratulation mighty warrior.");
            Human.receiveLoot();
        } else {
            System.out.print("\n You have taken " + damage + " damage." +
                    "\n You now have " + humanHealth + " HP left.");
        }
    }
    }
}
