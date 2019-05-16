import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/*
    A CLASS CREATED FOR THE OLE PURPOSE OF TESTING OUT FUNCTIONS AND NEW METHODS.
    HAS NO CONNECTIONS TO THE ACTUAL GAME.
    MUST BE DELETED BEFORE FINAL RELEASE.
 */

public class Tester {

    Scanner in = new Scanner(System.in);
//
//    public int LuckyDraw(int x) {
//        Random R = new Random();
//        int[] arr = new int[x + 1];
//        final int constant = 3;
//        int bound = (int) Math.pow(x, constant);
//        int random = R.nextInt(bound);
//        for (int i = x; i > 0; i--) {
//            arr[i] = (int) (Math.pow(i, constant) + Math.pow(constant, i));
//
//        }
//
//        for (int i = x; i > 0; i--) {
//            if (random >= arr[i - 1] && random <= arr[i]) {
//                System.out.println(arr[i - 1] + " " + arr[i] + " " + random);
//                return i;
//            }
//
//        }
//        return 0;
//
//    }

    Appearance A = new Appearance();


    public static void main(String[] args) throws InterruptedException, IOException {
        Villager V = new Villager();
        System.out.print(V.dialogue +"\n"+V.name);
//        Appearance A = new Appearance();
//        String cur = System.getProperty("user.dir");
//        String os = System.getProperty("os.name");
//        String home = System.getProperty("user.home");
//        System.out.println(cur+"\n"+home+"\n"+os);
//        FileAccess fileAccess = new FileAccess();
//        String a = fileAccess.ResourceDirectory();
//        System.out.println(a);
//        Tester l = new Tester();
//        while(true) {
//            System.out.println("enter val > ");
//            int x = in.nextInt();
//
//            System.out.println("result = " +l.LuckyDraw(x));
//int hp = 0;
//        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\trainee_3\\Desktop\\test.txt"))) {
//            String line = bufferedReader.readLine();
//            while(line != null) {
//                    String nextLine = bufferedReader.readLine();
//                    TimeUnit.SECONDS.sleep(2);
//
//                    System.out.println(line + " " + nextLine);
//
//
//                line = bufferedReader.readLine();
//            }
//        } catch (FileNotFoundException e) {
//            // exception handling
//        } catch (IOException e) {
//            // exception handling
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

//        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\trainee_3\\IdeaProjects\\CatfishFiles\\src\\DeathDialoguesPlayer"))) {
//            String line = bufferedReader.readLine();
//            while(line != null) {
//                String nextLine = bufferedReader.readLine();
//                TimeUnit.SECONDS.sleep(2);
//
//                System.out.println(line + " " + nextLine);
//
//
//                line = bufferedReader.readLine();
//            }
//        } catch (FileNotFoundException e) {
//            // exception handling
//        } catch (IOException e) {
//            // exception handling
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//            theCity C = new theCity();
//            C.exploreCity();
//
//    Tester T = new Tester();
//    T.printBox();

       //A.underLine("Hello",'*');
    }

//
//    public void topBottom(int length) {
//        System.out.print("+");
//        for (int i = 0; i <= length + 1; i++)
//            System.out.print("-");
//        System.out.println("+");
//    }
//
//    public void printBox() {
//
//        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\trainee_3\\IdeaProjects\\CatfishFiles\\src\\ForestStories"))) {
//            String line = bufferedReader.readLine();
//            while(line != null) {
//               A.putInBox(line);
//                line = bufferedReader.readLine();
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


}

