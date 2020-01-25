package TestingGrounds;



import catfishfiles.MainPackage.Bag;
import catfishfiles.MainPackage.Weapon;
import java.io.IOException;
import java.util.Scanner;


/*
    A CLASS CREATED FOR THE OLE PURPOSE OF TESTING OUT FUNCTIONS AND NEW METHODS.
    HAS NO CONNECTIONS TO THE ACTUAL GAME.
    MUST BE DELETED BEFORE FINAL RELEASE.
 */
public class Tester {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner in = new Scanner(System.in);
        Bag B = new Bag();
        Weapon w = Weapon.newRandomIronInstance();

        B.addToBag(w);

        B.listAll();
        System.out.println("Enter item code to remove");
        int x = in.nextInt();
        B.removeWeapon(x);
    }

}
