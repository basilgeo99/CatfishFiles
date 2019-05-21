package catfishfiles.MainPackage;


import catfishfiles.MainPackage.FileOps.FileAccess;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import jxl.write.WriteException;

/*
    THE GAME EXECUTION STARTS HERE.
    WILL ASK IF SAVE FILES NEEDS TO BE LOADED
    WILL OPEN THE STORY EXCEL  FILE
    WILL START THE STORY FROM STORY CLASS(NEEDS TO BE MADE)


 */
public class MainLine {

    public static void main(String[] args) throws IOException, InterruptedException, WriteException, FileNotFoundException, ClassNotFoundException {
        FileAccess F = new FileAccess();
        F.printArt("TEST");
        Scanner in = new Scanner(System.in);
        Player P = new Player();        

        System.out.println("\nName : ");
        P.name = in.nextLine();
        System.out.println();
        P = F.LoadObject(P);
        System.out.println( P.stats());

        BattleEye B = new BattleEye();
        B.BattleRequest("normal",P);

    }

}
