package catfishfiles.MainPackage;


import java.io.Serializable;
import java.util.LinkedList;
import java.util.Scanner;

/*

        THIS CLASS IS YET TO BE DESIGNED AND IMPLEMENTED

        WITH THE INCLUSION OF THIS CLASS THE WEAPONS AND POTIONS WILL HAVE A WEIGHT
        ATTRIBUTE determining how much stuff can be carried at pos time.

(   Feature to be implemented later
                If too much is carried the player will be prompted to discard some items. 
)

        DESIGNED            -   NO
        IMPLEMENTED         -   NO

        CHANGES TO BE MADE :
 */
public class Bag implements Serializable {

    LinkedList<Potion> PBag = new LinkedList<>();
    LinkedList<Weapon> WBag = new LinkedList<>();

    public void addToBag(Object o) {
        if (o.getClass().getSimpleName().equalsIgnoreCase("weapon")) {
            WBag.add((Weapon) o);
        } else if (o.getClass().getSimpleName().equalsIgnoreCase("potion")) {
            PBag.add((Potion) o);
        } else {
            System.out.println("Failed to add - for the notice of DEVELOPERS");
        }
    }

    public void listAll() {
        Appearance A = new Appearance();
        A.putInBox("BAG", 'b');
        listPotions();
        listWeapons();
    }

    public void listPotions() {
        Appearance A = new Appearance();
        A.underLine("POTIONS", '=');
        int size = PBag.size();
        for (int i = 0; i < size; i++) {
            Potion P = PBag.get(i);
            System.out.println((i + 1) + " :: " + P.stats());
        }
    }

    public void listWeapons() {
        Appearance A = new Appearance();
        A.underLine("WEAPONS", '=');
        int size = WBag.size();
        for (int i = 0; i < size; i++) {
            Weapon W = WBag.get(i);
            System.out.println((i + 1) + " :: " + W.stats());
        }
    }

    public void removePotion(int position) {
        Potion P = PBag.remove(position - 1);
        System.out.println(P.name + " removed");
    }

    public void removeWeapon(int position) {
        Weapon W = WBag.remove(position - 1);
        System.out.println(W.name + " removed");
    }

} //Bag Class Closed

