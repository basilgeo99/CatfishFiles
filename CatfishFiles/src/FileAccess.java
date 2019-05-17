
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import jxl.write.WriteException;

/*
 *  THIS CLASS DEALS WITH EXTERNAL FILE ACCESS
 *  IT IS A TYPE OF SUPPORTIVE CLASS THAT EXISTS TO
 *  HELP OTHER CLASSES.
 */
/**
 *
 * @author tulsi
 */
public class FileAccess {
    ExcelRW excelObject =  new ExcelRW();
    

    public String RandomTextfromFile(String fileName) throws IOException {

        String home = PresentWorkingDirectory();
        String fileLocation = home + fileName;
        int bound = lineCount(fileLocation);
        Random R = new Random();
        int i = R.nextInt(bound);
        FileReader fr = new FileReader(fileLocation);
        try (BufferedReader bufferedReader = new BufferedReader(fr)) {
            String line = bufferedReader.readLine();
            while (line != null) {
                if (line.equalsIgnoreCase(String.valueOf(i))) {
                    line = bufferedReader.readLine();
                    return line;
                } else {
                    line = bufferedReader.readLine();
                }
            }
        } catch (FileNotFoundException e) {
            // exception handling
        } catch (IOException e) {
            // exception handling
        }

        return "";

    }

    public String PresentWorkingDirectory() throws IOException {
        String os = System.getProperty("os.name");
        String directory = System.getProperty("user.dir");

        if (os.contains("Linux")) {
            directory += "/Resources/";
        } else if (os.contains("Windows")) {
            directory += "\\Resources\\";
        }
        return directory;

    }

    private int lineCount(String fileLocation) throws FileNotFoundException, IOException {
        /*
            Return the number of line of text in the file
            we use count/2 because in our textfile every  line of 
            text is preceeded by an identifying number.
            So the actual number of lines of text is only half the overall lines.
         */
        BufferedReader reader = new BufferedReader(new FileReader(fileLocation));
        int lines = 0;
        while (reader.readLine() != null) {
            lines++;
        }
        reader.close();

        return lines / 2;
    }

    public void  SaveGame(Player P) throws IOException, WriteException {
        String output = PresentWorkingDirectory() + P.name + ".xls";
        excelObject.setOutputFile(output);
        excelObject.write(P);
    }
    
    public Player LoadGame(String name){
        Player P = new Player();
        
        return P;
    }

}
