package catfishfiles.MainPackage;

/*

    THE WORLD MAP CLASS HAS ALL THE MAPS.
    MAPS OF THE CITY AND DUNGEONS WILL EXIST HERE.
    FORESTS HAVE NO MAPS.
    DUNGEONS WILL HAVE SEVERAL MAPS DEPENDING UPON THE NUMBER OF FLOORS EACH OF THEM HAVE.

    DESIGNED            -   NO
    IMPLEMENTED         -   NO


    CHANGES TO BE MADE :
        1. THE WORLD MAP NEEDS TO BE REDESIGNED WITH NEW NAMES FOR THE PLACES
        2. CITY MAP
        3. DUNGEON MAPS

 */


 /*
WORLD STRUCTURE:
theCity
Forest surrounding theCity
North Dungeon  - NOUXT
South Dungeon  - SOUXT
East Dungeon   - EAUXT
West Dungeon   - WASXT

             +---------+
             |   North |
             |         |
             +---------+
             |	       |
             | nf	   |
+------+-----+---------+------+------+
|      |     |         |      |      |
| west |  WF |   city  |  EF  |  east|
|      |     |         |      |      |
+------+-----+---------+------+------+
             |    sf   |
             |         |
             +---------+
             | South   |
             | 	       |
             +---------+

 Array for possible routes :
        city NF  SF  EF  WF   N   S   E   W
        +---+---+---+---+---+---+---+---+---+
   city | 0   1   1   1   1   1   1    1   1
        +---+---+---+---+---+---+---+---+---+
   NF   | 1                   1
        +---+---+---+---+---+---+---+---+---+
   SF   | 1                       1
        +---+---+---+---+---+---+---+---+---+
   EF   | 1                           1
        +---+---+---+---+---+---+---+---+---+
   WF   | 1                               1
        +---+---+---+---+---+---+---+---+---+
   N    | 1   1
        +---+---+---+---+---+---+---+---+---+
   S    | 1       1
        +---+---+---+---+---+---+---+---+---+
   E    | 1           1
        +---+---+---+---+---+---+---+---+---+
   W    | 1               1
        +---+---+---+---+---+---+---+---+---+
 */
public class WorldMap {

    public void showWorldMap() {
        System.out.println("           \t\t+---------+\n"
                + "\t         \t|   North |\n"
                + "\t\t        |         |\n"
                + "\t\t        +---------+\n"
                + "\t         \t|\t      |\n"
                + "\t\t        | nf\t  |\n"
                + "   +------+-----+---------+------+------+\n"
                + "   |      |     |         |      |      |\n"
                + "   | west |  WF |   city  |  EF  |  east|\n"
                + "   |      |     |         |      |      |\n"
                + "   +------+-"
                + ""
                + "----+---------+------+------+\n"
                + "\t\t        |    sf\t  |\n"
                + "\t\t        |         |\n"
                + "\t         \t+---------+\n"
                + "\t         \t| South\t  |\n"
                + "\t         \t| \t      |\n"
                + "\t\t        +---------+");

    }

}
