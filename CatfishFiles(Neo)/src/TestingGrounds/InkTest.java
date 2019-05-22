package TestingGrounds;


import com.bladecoder.ink.runtime.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author trainee_3
 */
public class InkTest {

    public static void main(String[] args) throws Exception {

        InkTest it = new InkTest();
        it.loadJSON();
    }

    //Function to read and interpret the JSON file written using  INK
    public void loadJSON() throws IOException, Exception {
        Scanner in = new Scanner(System.in);
        StringBuilder sb;
        String filename = "story.json";                 //the story is saved here
        InputStream is = ClassLoader.getSystemResourceAsStream(filename);               //adding the file to an input stream
        InputStreamReader isr = new InputStreamReader(is, "UTF-8");             //reading the input stream using a reader in UTF-8  format(optional)
        try (BufferedReader br = new BufferedReader(isr)) {                                 //buffer queueing the input stream reader
            sb = new StringBuilder();
            String line = br.readLine();                                                                            // read a line from the buffer

            while (line != null) {                                                              //execute if line is not empty
                sb.append(line);                                                                // add to string builder
                sb.append("\n");                                                                //new line for the next line
                line = br.readLine();                                                          //iterating varibale for this while loop taking the next value
            }

        }

        String json = sb.toString().replace('\uFEFF', ' ');                     // replacing all Byte Order Mark (saved as error \uFEFF) in JSON to blank spaces

        Story story = new Story(json);                      //creating  a variable of the ink's Story class with our json story String

        while (story.canContinue()) {                           //while there is another line in the story
            String line = story.Continue();                      //retrieves the current lin in the story
            System.out.print(line);                                     //print that line (whether story or choice)
            if (story.getCurrentChoices().size() > 0) {         //if more than one choice then for lop

                for (int i = 0; i < story.getCurrentChoices().size(); ++i) {                //prints all the availble choices in the game
                    Choice choice = story.getCurrentChoices().get(i);
                    System.out.println("Choice " + (i) + ". " + choice.getText());
                    
                    /*
                    code to check if the choice contains a certain word
                    
                    String jest = "course";
                    if (choice.getText().contains(jest)) {
                    System.err.println("JASHDKSHDSUAHDSADSADGSAIUD");
                    }*/
                    
                    
                }
                story.chooseChoiceIndex(in.nextInt());              //asking user to input choice as int value
            }
        }

    }

}
