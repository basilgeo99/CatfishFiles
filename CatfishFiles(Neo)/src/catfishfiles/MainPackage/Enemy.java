package catfishfiles.MainPackage;


import java.io.IOException;
import java.util.Random;

/*
    THIS CLASS HAS ATTRIBUTES AND FUNCTIONS PERTAINING TO ENEMIES IN THE GAME.
    THEY ARE OF TWO TYPES : NORMAL AND BOSS TYPES

    DESIGNED            -   YES
    IMPLEMENTED         -   YES

    CHANGES TO BE MADE :

 */

public class Enemy {

    Weapon W;
    int hp;
    int dmg;
    int lvl;
    int coins;
    String name;
    Random R = new Random();

    Enemy(String name, int hitPoints, int minDamage, int maxDamage) {
        this.name = name;
        this.hp = hitPoints;
        this.dmg = R.nextInt(minDamage + maxDamage) + 1;
        this.coins = R.nextInt(minDamage + maxDamage);
    }

    public int attack() {
        return dmg;
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public String stats() {
        String stats = "\tSTATS\n" + "\n\tName : " + name + "\n\tHP : " + hp + "\n\tDMG : " + dmg + "\n\tCoins : " + coins;
        return stats;
    }

    public void defend(Player P) throws IOException {

        int ap = P.attack();

        hp = (ap > hp) ? 0 : (hp - ap);
        System.out.println(P.name + " does " + ap + " damage.");
        if (isAlive()) {
        } else {
            System.out.print(death());
        }
    }

    public String death() throws IOException {
        /*
            Prints a random death dialogue for the enemy
         */
        FileAccess F = new FileAccess();
        return name + F.RandomTextfromFile("DeathDialoguesEnemy");
    }

    public static Enemy newRandomInstance() {

        Random R = new Random();
        int i = R.nextInt(15) % 6;

        switch (i) {
            case 0:
                return new Enemy("Harpy", 30, 8, 12);

            case 1:
                return new Enemy("Gargoyle", 22, 4, 13);

            case 2:
                return new Enemy("Hobgoblin", 18, 4, 11);

            case 3:
                return new Enemy("Gnole", 35, 4, 10);

            case 4:
                return new Enemy("Goblin", 26, 5, 12);

            default:
                return new Enemy("Soot Spirit", 12, 3, 6);
        }
    }

    public static Enemy newBossInstance() {
        System.out.println("You have encountered an Enemy Boss");
        Random R = new Random();
        int i = R.nextInt(15) % 6;

        switch (i) {
            case 0:
                return new Enemy("Dragon", 82, 13, 30);

            case 1:
                return new Enemy("Undead King", 66, 12, 24);

            case 2:
                return new Enemy("Goblin Warlord", 58, 10, 22);

            case 3:
                return new Enemy("Possessed Knight", 60, 10, 24);

            case 4:
                return new Enemy("Demon Lord", 72, 13, 28);

            default:
                return new Enemy("Wraith", 44, 7, 17);
        }

    }

}
