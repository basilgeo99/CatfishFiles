import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/*
    THE GAME EXECUTION STARTS HERE.
    WILL ASK IF SAVE FILES NEEDS TO BE LOADED
    WILL OPEN THE STORY EXCEL  FILE
    WILL START THE STORY FROM STORY CLASS(NEEDS TO BE MADE)


 */
public class MainLine {

    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner in = new Scanner(System.in);
        Player P = new Player();

        System.out.println("Name : ");
        P.name = in.nextLine();
        System.out.println();


        BattleEye B = new BattleEye(P);
        B.BattleRequest("n");



    }


}
