import java.util.Random;

/*
    THIS CLASS HAS THE ATTRIBUTES PERTAINING TO A WEAPON

    DESIGNED            -   INCOMPLETE
    IMPLEMENTED         -   NO

    CHANGES TO BE MADE :
        1. MUST INTRODUCE A WEIGHT ATTRIBUTE FOR BAG CLASS PURPOSES
 */
public class Weapon extends Parent {
   //String name;
    int dmg;    
    int cost;
    Random R = new Random();

    Weapon() {
    }

    public String stats(){
        String stats = "\nName : "+name+"\nDMG : "+dmg+"\nCost : "+cost;
        return stats;
    }

    Weapon (String name,int cost, int minDamage, int maxDamage){
        this.name = name;
        this.dmg = R.nextInt(minDamage+maxDamage)+1;
        this.cost = cost;
    }

    Weapon (String name,int cost, int fixedDamage){
        this.name = name;
        this.dmg = fixedDamage;
        this.cost = cost;
    }

    /*
    THE DIFFERENT WEAPON CLASSES

    Iron --> Steel --> Glass --> BloodOak --> Dragon

    Special Class is separate and very rare.
     */


    public static Weapon newRandomIronInstance() {
        System.out.println("$$$$$$$");
        Random R = new Random();
        int i = R.nextInt(15)%5;


        switch(i) {
            case 0 :
                return new Weapon("Iron Sword", 17, 1, 9);

            case 1 :
                return new Weapon("Iron Axe", 17, 1, 11);

            case 2 :
                return new Weapon("Iron Knife", 16, 1, 12);

            case 3 :
                return new Weapon("Iron Spoon", 6, 1, 10);

            default:
                return new Weapon("Housewife's Frying Pan", 20, 1, 13);
        }
    }

    public static Weapon newRandomSteelInstance() {
        System.out.println("$$$$$$$");
        Random R = new Random();
        int i = R.nextInt(15)%5;


        switch(i) {
            case 0 :
                return new Weapon("Steel Sword", 22, 2, 13);

            case 1 :
                return new Weapon("Steel Axe", 25, 3, 15);

            case 2 :
                return new Weapon("Steel Knife", 28, 3, 17);

            case 3 :
                return new Weapon("Steel Spoon", 27, 1, 18);

            default:
                return new Weapon("Housewife's Knife", 29, 1, 19);
        }
    }

    public static Weapon newRandomGlassInstance() {
        System.out.println("$$$$$$$");
        Random R = new Random();
        int i = R.nextInt(15)%5;


        switch(i) {
            case 0 :
                return new Weapon("Glass Sword", 47, 4, 20);

            case 1 :
                return new Weapon("Glass Axe", 39, 4, 22);

            case 2 :
                return new Weapon("Glass Knife", 44, 4, 26);

            case 3 :
                return new Weapon("Glass Spoon", 48, 1, 26);

            default:
                return new Weapon("Housewife's Kettle", 45, 1, 29);
        }
    }

    public static Weapon newRandomBloodOakInstance() {
        System.out.println("$$$$$$$");
        Random R = new Random();
        int i = R.nextInt(15)%5;


        switch(i) {
            case 0 :
                return new Weapon("BloodOak Sword", 66, 6, 32);

            case 1 :
                return new Weapon("BloodOak Axe", 78, 6, 34);

            case 2 :
                return new Weapon("BloodOak Knife", 72, 6, 38);

            case 3 :
                return new Weapon("BloodOak Spoon", 82, 1, 37);

            default:
                return new Weapon("Housewife's Washing Board", 87, 1, 42);
        }
    }

    public static Weapon newRandomDragonInstance() {
        System.out.println("$$$$$$$");
        Random R = new Random();
        int i = R.nextInt(15)%5;


        switch(i) {
            case 0 :
                return new Weapon("Dragon Sword", 147, 22, 64);

            case 1 :
                return new Weapon("Dragon Axe", 144, 25, 68);

            case 2 :
                return new Weapon("Dragon Knife", 157, 30, 66);

            case 3 :
                return new Weapon("Dragon Spoon", 160, 10, 69);

            default:
                return new Weapon("Housewife's Husband", 220, 10, 69);
        }
    }

    public static Weapon newRandomSpecialInstance() {
        System.out.println("$$$$$$$");
        Random R = new Random();
        int i = R.nextInt(123)%5 ;


        switch(i) {
            case 0 :
                return new Weapon("Morning Coffee", 178, 74);

            case 1 :
                return new Weapon("Holy Water", 187, 78);

            case 2 :
                return new Weapon("Basics of Trigonometry Textbook", 157, 76);

            case 3 :
                return new Weapon("Spork", 180, 79);

            default:
                return new Weapon("Fire Extinguisher", 200, 89);
        }
    }


}
