package catfishfiles.MainPackage;

import catfishfiles.MainPackage.FileOps.FileAccess;
import java.io.IOException;
import java.io.Serializable;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/*
       THIS CLASS HAS ATTRIBUTES AND FUNCTIONS OF THE PLAYER
       ONLY ONE PLAYER CAN EXIST IN THE GAME AT A TIME.

       DESIGNED         -   YES
       IMPLEMENTED      -   YES

       CHANGES TO BE MADE :
        1. MUST ADD A BAG ATTRIBUTE AND SET A MAX WEIGHT.
 */
public final class Player implements Serializable{

    public   int hp;
    public  int dmg;
    public  int lvl;
    public  int coins;
    public   int potions;
    public  String name;
     Weapon currentWeapon = null;
     Bag B = new Bag();
    

    public Player() {
        B.addToBag(Weapon.newRandomIronInstance());
        B.addToBag(Potion.newHealingInstance());
        B.addToBag(Potion.newHealingInstance());
        currentWeapon = B.WBag.get(0);
        hp = 56;
        dmg = 11 + currentWeapon.dmg;
        lvl = 1;
        coins = 44;
        potions = 2;

    }

    public String stats() {
        String stats = "\tSTATS\n" + "\n\tName : " + name + "\n\tHP : " + hp + "\n\tDMG : " + dmg + "\n\tPotions : " + potions + "\n\tCoins : " + coins + "\n\tCurrent Weapon : " + currentWeapon.name;
        return stats;
    }

    public int attack() {
        return dmg;
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public void defend(Enemy E) throws IOException, InterruptedException {
        TimeUnit.MILLISECONDS.sleep(500);
        int ap = E.attack();                                            //attack points
        hp = (ap > hp) ? 0 : (hp - ap);
        System.out.println("\n"+E.name + " does " + ap + " damage.");
        if (isAlive()) {
        } else {
            System.out.println("\n"+death());
        }
    }

    public void heal() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(500);
        Random R = new Random();
        if (potions > 0) {
            potions--;
            hp = (hp + R.nextInt(20));
            System.out.println("HP healed to " + hp);
        } else {
            System.out.println("No potions left to use");
        }
    }

    public String death() throws IOException, InterruptedException {
        /*
        Prints a random dialogue from DeathDialoguesPlayer file
         */
        TimeUnit.MILLISECONDS.sleep(500);
        FileAccess F = new FileAccess();
        return F.RandomTextfromFile("DeathDialoguesPlayer");
    }

    public void bagAccess() {
        Scanner in = new Scanner(System.in);
        System.out.println("Use (P)otions   ///    Change (W)eapon  ?  \n>>>");
        String choice = in.nextLine();
        if (choice.equalsIgnoreCase("p")) {
            usePotions();
        } else if (choice.equalsIgnoreCase("w")) {
            changeWeapon();
        } else {
            return;
        }
    }

    public void usePotions() {
        Scanner in = new Scanner(System.in);
        B.listPotions();
        System.out.println("Use potion >>> )");
        int pos = in.nextInt();
        if (pos > B.PBag.size() || pos < 1) {
            System.out.println("Invalid option.");
            bagAccess();
        } else {
            Potion P = B.PBag.remove(pos - 1);
            System.out.println("HP + "+P.value+" = "+(hp+P.value));
            hp += P.value;
        }
    }

    public void changeWeapon() {
        Scanner in = new Scanner(System.in);
        B.listWeapons();
        System.out.println("Select Weapon >>> )");
        int pos = in.nextInt();
        if (pos > B.WBag.size() || pos < 1) {
            System.out.println("Invalid option.");
            bagAccess();
        } else {
            Weapon W = B.WBag.get(pos-1);
            currentWeapon = W;
        }
    }
}
