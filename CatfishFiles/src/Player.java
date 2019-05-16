import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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

public final class Player {
    int hp;
    int dmg;
    int lvl;
    int coins;
    int potions;
    String name;
    Weapon W;
    Scanner sc = new Scanner(System.in);
    Random R = new Random();



    public Player() {
        hp = 56;
        dmg = 11;
        lvl = 1;
        coins = 44;
        potions = 2;


    }

    public String stats(){
        String stats = "\tSTATS\n"+"\n\tName : "+name+"\n\tHP : "+hp+"\n\tDMG : "+dmg+"\n\tPotions : "+potions+"\n\tCoins : "+coins;
        return stats;
    }

    public int attack(){
        return dmg;
    }

    public boolean isAlive(){
        return hp>0;
    }

    public void defend(Enemy E) throws IOException{

        int ap = E.attack();

        hp = (ap>hp)?0:(hp-ap);
        System.out.println(E.name+" does " + ap +" damage.");
        if(isAlive()){
        }
        else{
            System.out.println(death());
        }
    }

    public void heal(){
        if(potions>0){
            potions--;
            hp = (hp + R.nextInt(20) );
            if(hp>100){
                hp=100;
            }
            System.out.println("HP healed to " + hp);
        }
        else{
            System.out.println("No potions left to use");
        }
    }

    public String death() throws IOException{
        /*
        Prints a random dialogue from DeathDialoguesPlayer file
         */
        FileAccess F = new FileAccess();
        return F.ResourceDirectory("DeathDialoguesPlayer");
    }
}
