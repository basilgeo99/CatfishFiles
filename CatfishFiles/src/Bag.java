/*

        THIS CLASS IS YET TO BE DESIGNED AND IMPLEMENTED

        WITH THE INCLUSION OF THIS CLASS THE WEAPONS AND POTIONS WILL HAVE A WEIGHT
        ATTRIBUTE determining how much stuff can be carried at a time.

        If too much is carried the player will be prompted to discard some items.

        DESIGNED            -   NO
        IMPLEMENTED         -   NO

        CHANGES TO BE MADE :
 */

public class Bag {

    int maxweight;            // weight will be as in the number of items you can carry
    Object[] items;

    Bag() {
        maxweight = 12;
        items = new Object[maxweight];
    }

    public void inventory() {

    }

    /*
    Object[] x = new Object[]{1,2,3,"srk"};
            for(Object o: x){
                System.out.println(o.getClass());
            }
     */
}
