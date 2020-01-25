package catfishfiles.MainPackage;


import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/*
    THIS THE CLASS WHERE THE CITY IS GENERATED.

    DESIGNED            -   INCOMPLETE
    IMPLEMENTED         -   NO

    CHANGES TO BE MADE :
        1. QUEST BOARD NEEDS TO BE MADE
        2. A SAVE POINT NEEDS TO BE MADE
        3. A LOAD SAVE NEEDS TO BE MADE
        4. SHOP NEEDS TO SELL DIFFERENT TYPES OF POTIONS (PART OF EXPANSION PACK - REQUIRES A POTION CLASS)

 */

public class City {

    Scanner in = new Scanner(System.in);
    Appearance A = new Appearance();

    public void theCity(Player P) throws InterruptedException, IOException {
        String text = A.strikethrough("THE CITY", 7, '=', '-');
        A.putInBox(text, '+');
        TimeUnit.SECONDS.sleep(1);
        System.out.print("\n\tVisit the (S)hop\n\t(E)xplore the theCity\n\t(Q)uest Board\n\t(V)enture Out\n\t>>>");
        String str = in.next();
        if (str.equalsIgnoreCase("s")) {
            shop(P);
        } else if (str.equalsIgnoreCase("e")) {
            exploreCity();
        } else if (str.equalsIgnoreCase("q")) {
            questBoard();
        } else if (str.equalsIgnoreCase("v")) {
            ventureOut(P);
        } else {
            System.out.println("The young Hero had trouble reading the options.\n The world grants Him another try.\n");
            theCity(P);
        }

    }

    public void shop(Player P) throws InterruptedException, IOException {
        String text = A.strikethrough("HEDMA'S WARES", 7, '=', '-');
        A.putInBox(text, '+');
        TimeUnit.SECONDS.sleep(1);
        text = A.strikethrough("PURCHASE ", 7, '=', '-');
        System.out.println(text + "\n\t(P)otions (9 coins) \n\t(W)eapons\n\t(L)eave\n\t>>>");
        String str = in.next();

        if (str.equalsIgnoreCase("p")) {
            System.out.println("Potions cost 9 coins a vial.\nHow many >>> ");
            int a = in.nextInt();
            if (a * 9 > P.coins) {
                System.out.println("\nYou do not have the funds.");
            } else {
//                P.coins-=(a*9);
//                P.potions+=a;
            }
            shop(P);
        } else if (str.equalsIgnoreCase("W")) {
            Weapon W1 = Weapon.newRandomIronInstance();
            Weapon W2 = Weapon.newRandomSteelInstance();
            Weapon W3 = Weapon.newRandomGlassInstance();

            System.out.println("(I) : ");
            W1.stats();
            System.out.println("(S) : ");
            W2.stats();
            System.out.println("(G) : ");
            W3.stats();

            System.out.print(">>>");
            String a = in.next();

            if (a.equalsIgnoreCase("i")) {
                if (P.coins > W1.cost) {
                    P.coins -= W1.cost;
                    //add to bag wala code
                } else {
                    System.out.println("\nYou do not have the funds.");
                }
            } else if (a.equalsIgnoreCase("s")) {
                if (P.coins > W2.cost) {
                    P.coins -= W2.cost;
                    //add to bag wala code
                } else {
                    System.out.println("\nYou do not have the funds.");
                }
            } else if (a.equalsIgnoreCase("g")) {
                if (P.coins > W3.cost) {
                    P.coins -= W3.cost;
                    //add to bag wala code
                } else {
                    System.out.println("\nYou do not have the funds.");
                }
            }
            shop(P);
        } else if (str.equalsIgnoreCase("L")) {
            theCity(P);
        } else {
            System.out.println("The young Hero had trouble reading the options.\n The world grants Him another try.\n");
            shop(P);
        }
    }

    public void questBoard() {
        System.out.println("\n\"\"Coming soon in the Expansion Pack!\"\"");
    }

    public void exploreCity() throws InterruptedException, IOException {
        TimeUnit.SECONDS.sleep(1);
        System.out.println("You meet a Villager.");
        TimeUnit.MILLISECONDS.sleep(400);
        System.out.println(" \"\" ");
        Villager V = new Villager();
        System.out.println(V.name + "\n" + V.dialogue);
        System.out.println(" \"\" ");
    }

    public void ventureOut(Player P) throws IOException, InterruptedException {

        System.out.println("\n=-=-=-=-=-= THE CITY GATES =-=-=-=-=-=");
        System.out.print("\n(N)orth Gate\n(S)outh Gate\n(E)ast Gate\n(W)est Gate\n(L)eave>>>");
        String a = in.next();
        if (a.equalsIgnoreCase("n")) {

        } else if (a.equalsIgnoreCase("s")) {

        } else if (a.equalsIgnoreCase("e")) {

        } else if (a.equalsIgnoreCase("w")) {

        } else if (a.equalsIgnoreCase("l")) {
            theCity(P);
        } else {
            System.out.println("The young Hero had trouble reading the options.\n The world grants Him another try.\n");
            ventureOut(P);
        }

    }
}
