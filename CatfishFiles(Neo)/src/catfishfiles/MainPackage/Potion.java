package catfishfiles.MainPackage;


import java.util.Random;

/**
 * A CLASS FOR ALL THE POTIONS IN THE GAME
 */
public class Potion {

    String name;
    int value;          // either + or - depending on whether it is an elixir or poison
    int cost;

    public String stats() {
        String stats = "\nName : " + name + "\nValue : " + value + "\nCost : " + cost;
        return stats;
    }

    Potion(String name, int cost, int value) {
        this.name = name;
        this.value = value;
        this.cost = cost;
    }

    public static Potion newHealingInstance() {
        Random R = new Random();
        int i = R.nextInt(15) % 5;

        switch (i) {
            case 0:
                return new Potion("Mayet Ixis", 17, 15);

            case 1:
                return new Potion("Willow's Wisp", 19, 20);

            case 2:
                return new Potion("Oak Blood", 22, 25);

            case 3:
                return new Potion("Miral Water", 30, 28);

            default:
                return new Potion("Healing Poison", 33, 35);
        }
    }

    public static Potion newPoisonInstance() {
        Random R = new Random();
        int i = R.nextInt(15) % 5;

        switch (i) {
            case 0:
                return new Potion("Mayet Carlus", 17, -14);

            case 1:
                return new Potion("Weed Pus", 18, - 17);

            case 2:
                return new Potion("Stale Milk", 19, -22);

            case 3:
                return new Potion("Blood Wine", 22, -23);

            default:
                return new Potion("Paling Poison", 25, -21);
        }
    }

}
