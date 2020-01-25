package catfishfiles.MainPackage;


import catfishfiles.MainPackage.FileOps.FileAccess;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import jxl.write.WriteException;

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
    FileAccess F = new FileAccess();
    Enemy E;
    Player P;


    /*a generic battle system*/
    public BattleEye() {        
    }

    //Pass N for normal enemies and B for bosses
    public void BattleRequest(String enemyType,Player P) throws InterruptedException, IOException, WriteException {
        this.P = P;
        if (enemyType.equalsIgnoreCase("boss")) {
            E = Enemy.newBossInstance();
        } else {
            E = Enemy.newRandomInstance();
        }
        System.out.println(E.name + " has appeared");
        StartBattle();

    }

    //All battles happen here at this function between 1 player and 1 enemy
    private void StartBattle() throws InterruptedException, IOException, WriteException {
        TimeUnit.MILLISECONDS.sleep(500);

        String text = A.strikethrough("BATTLE", 7, '=', '-');
        A.putInBox(text, '#');

        String roster = P.name + " vs " + E.name;
        A.putInBox(roster, '#');

        battleChoice:
        while (P.isAlive() && E.isAlive()) {
            TimeUnit.MILLISECONDS.sleep(500);
            A.putInBox(P.stats(), '#');
            TimeUnit.MILLISECONDS.sleep(500);
            A.putInBox(E.stats(), '#');
            System.out.print("\n(A)ttack    ///   (B)ag  ?  \n>>> ");
            String action = in.nextLine();
            if (action.equalsIgnoreCase("a")) {
                E.defend(P);
            } else if (action.equalsIgnoreCase("b")) {
                P.bagAccess();
            } else {
                continue battleChoice;    //if the user hits something other than A or H then goto the label.
            }
            if (E.isAlive()) {
                P.defend(E);
            }
        }
        TimeUnit.MILLISECONDS.sleep(500);
        if (P.isAlive()) {
            P.coins += E.coins;
            System.out.println("\n" + E.coins + " earned || Total coins : " + P.coins);
        } else {
            P.coins = 0;
            System.out.println("\n" + E.name + " makes away with all your " + P.coins + " coins.");
        }

        F.SaveObject(P);    // a cleaner way to save the game ... this way when we want to save game 
        // we just call the FileAccess.SaveGame function and pass a Player object.

    }

}
