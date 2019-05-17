import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


/*
    A CLASS CREATED FOR THE OLE PURPOSE OF TESTING OUT FUNCTIONS AND NEW METHODS.
    HAS NO CONNECTIONS TO THE ACTUAL GAME.
    MUST BE DELETED BEFORE FINAL RELEASE.
 */

public class Tester {

    Scanner in = new Scanner(System.in);
   
    
//
//    public int LuckyDraw(int x) {
//        Random R = new Random();
//        int[] arr = new int[x + 1];
//        final int constant = 3;
//        int bound = (int) Math.pow(x, constant);
//        int random = R.nextInt(bound);
//        for (int i = x; i > 0; i--) {
//            arr[i] = (int) (Math.pow(i, constant) + Math.pow(constant, i));
//
//        }
//
//        for (int i = x; i > 0; i--) {
//            if (random >= arr[i - 1] && random <= arr[i]) {
//                System.out.println(arr[i - 1] + " " + arr[i] + " " + random);
//                return i;
//            }
//
//        }
//        return 0;
//
//    }

        public enum ObjectTypes  {
        WEAPON,
        POTION,
        GAMEOBJECT        
    }
    Appearance A = new Appearance();
 
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        
        Tester tester = new Tester();
        ObjectTypes types = null;
        
        System.out.println(types.WEAPON);
        Weapon W = Weapon.newRandomIronInstance();
        
         Bag b = new Bag();
         b.items[0] = W;
         b.inventory();
    }


}

