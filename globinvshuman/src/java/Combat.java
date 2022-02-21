public class Combat {
    static Goblin goblin = new Goblin();
    static Human human = new Human();

    public static void fight() {
        int damage = (int) (Math.random() * 9) + 1;

    for(int i = 0; i <= goblin.getHealth(); i++) {
        human.setHealth(human.getHealth() - damage);
        goblin.setHealth(goblin.getHealth() - damage);
        if (human.getHealth() <= 0) {
            System.out.print("\n Your human have died in combat!");
        } else if (goblin.getHealth() <=0 ){
            System.out.print("\n You have killed a goblin! Congratulation mighty warrior.");
            Human.receiveLoot();
        } else {
            System.out.print("\n You have taken " + damage + " damage." +
                    "\n You now have " + human.getHealth() + " HP left.");
        }
    }
    }
}
