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

