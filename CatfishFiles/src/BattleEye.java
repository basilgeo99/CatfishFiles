
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/*
    THIS CLASS HANDLES THE BATTLES IN THE GAME
    WHEN A BATTLE NEEDS TO HAPPEN A BATTLEREQUEST MUST BE MADE
    AT WHICH POINT AN ENEMY WILL BE GENERATED DEPENDING ON WHETHER
    IT NEEDS TO BE NORMAL OR BOSS TYPE.

    ONCE BATTLEREQUEST IS MADE AND ENEMY CREATED THEN BATTLE STARTS.

    DESIGNED        -   YES
    IMPLEMENTED     -   YES

    CHANGES TO BE MADE :
 */

public class BattleEye {
    Random R = new Random();
    Appearance A = new Appearance();
    Scanner in = new Scanner(System.in);
    Enemy E;
    Player P;


    /*a generic battle system*/

    public BattleEye(Player P){
        this.P = P;
    }

    //Pass N for normal enemies and B for bosses
    public void BattleRequest(String c) throws InterruptedException, IOException {
        if(c.equalsIgnoreCase("b")) {
            E = Enemy.newBossInstance();
        }else{
            E = Enemy.newRandomInstance();
        }
        System.out.println(E.name+" has appeared");
        StartBattle();

    }

    //All battles happen here at this function between 1 player and 1 enemy
    private void StartBattle() throws InterruptedException, IOException {
        TimeUnit.SECONDS.sleep(1);

        String text = A.strikethrough("BATTLE",7,'=','-');
        A.putInBox(text,'+');

        String roster = P.name + " vs " + E.name;
        A.putInBox(roster,'#');

        battleChoice:
        while (P.isAlive() && E.isAlive()) {
            TimeUnit.MILLISECONDS.sleep(400);
            A.putInBox(P.stats(),'#');
            A.putInBox(E.stats(),'#');
            System.out.print("\n(A)ttack or (H)eal ?  \n>>> ");
            String action = in.nextLine();
            if (action.equalsIgnoreCase("h")) {
                P.heal();
            } else if(action.equalsIgnoreCase("a")){
                E.defend(P);
            }
            else {
                continue battleChoice;    //if the user hits something other than A or H then goto the label.
            }
            if (E.isAlive()) {
                P.defend(E);
            }
            TimeUnit.SECONDS.sleep(1);
        }
        TimeUnit.MILLISECONDS.sleep(400);
        if(P.isAlive()){
            P.coins += E.coins;
            System.out.println("\n"+E.coins +" earned || Total coins : "+ P.coins);
        }else{
            P.coins = 0;
            System.out.println("\n"+E.name+" makes away with all your "+P.coins+" coins.");
        }

    }

}
