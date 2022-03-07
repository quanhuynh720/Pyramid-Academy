public class Combat {
    static Goblin goblin = new Goblin();
    static Human human = new Human();

    public static void fight() {
        int humanDamage = (int)(Math.random() * 10) + 1; //damage = strength/2
        int goblinDamage = (int)(Math.random() * 5) + 1;

    for(int i = 0; i <= goblin.getHealth(); i++) {
        human.setHealth(human.getHealth() - goblinDamage);
        goblin.setHealth(goblin.getHealth() - humanDamage);
        if (human.getHealth() <= 0) {
            System.out.print("\n Your human have died in combat!" +
                    "\n GAME OVER");
        } else if (goblin.getHealth() <=0 ){
            System.out.print("\n You have killed a goblin! Congratulation mighty warrior.");
//            System.out.print("\n You have taken " + goblinDamage + " damage." +
            System.out.print("\n You now have " + human.getHealth() + " HP left.");
            Human.receiveLoot();
            Land.movement();
        }
    }
    }
}
