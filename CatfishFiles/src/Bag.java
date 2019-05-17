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

    int maxWeight;            // weight will be as in the number of items you can carry
    Object[] items;
    int currWeight;
    enum ObjectTypes  {
        Weapon,
        Potion,
        GameObject        
    }

    Bag() {
        maxWeight = 12;
        items = new Object[maxWeight];
        currWeight = 0;
    }

    public boolean isFull() {
        return currWeight >= maxWeight;
    }

    public boolean isEmpty() {
        return currWeight <= 0;
    }

    public void inventory() {
        
        for(Object o : items){
            
            String type = getObjectClass(o);
            
            if(type.equalsIgnoreCase(ObjectTypes.Weapon.toString())){
                Weapon W = (Weapon)o;
                System.out.println(W.stats());
            }
            
            
        }

    }

    private String  getObjectClass(Object o)  {
                
        return o.getClass().getSimpleName();
    }

    /*
          Object[] x = new Object[]{1,2,3,"srk"};
                for(Object o: x){
                  System.out.println(o.getClass());                                         > class  java.lang.Integer
                  System.out.println(o.getClass().getName());                    > java.lang.Integer
                  System.out.println(o.getClass().getSimpleName());       > Integer
               }
     */
}
