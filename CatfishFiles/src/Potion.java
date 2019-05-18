
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

}
