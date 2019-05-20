package catfishfiles.MainPackage;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

/*
    THE FOREST  CLASS

    DESIGNED            -   INCOMPLETE
    IMPLEMENTED         -   NO

    CHANGES TO BE MADE :
        1. THE FOREST JOURNEY CLASS WILL HAVE RANDOM APPEARANCES OF ANIMAL OR MONSTER OR PEOPLE.
        2. THE GAME STARTS IN THE FOREST
        3. JOURNEY THROUGH THE FOREST HAPPENS WITH RIDDLES (2 OR 3 RIDDLES EVERYTIME THE FOREST NEEDS TO BE CROSSED)


 */
public class Forest {

    Appearance A = new Appearance();
    FileAccess F = new FileAccess();

    public Forest() throws InterruptedException, IOException {
        TimeUnit.SECONDS.sleep(2);
        String text = A.strikethrough("THE GREAT FOREST", 7, '=', '-');
        A.putInBox(text, '+');
        TimeUnit.SECONDS.sleep(1);
        System.out.println(" \"\" ");
        System.out.print(F.RandomTextfromFile("ForestStories"));
        System.out.println(" \"\" ");
    }

    public void ForestJourney() {
    }
}
