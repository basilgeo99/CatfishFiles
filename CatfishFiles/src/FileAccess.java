
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

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

    public String ResourceDirectory(String fileName) throws IOException {
        /*
            RETURNS THE DIRECTORY WHERE THE RESOURCE FILES ARE STORED 
            DEPENDING ON WHETHER IT IS A LINUX OR WINDOWS MACHINE
         */
        String os = System.getProperty("os.name");
        String home = System.getProperty("user.dir");

        if (os.contains("Linux")) {
            home += "/Resources/";
        } else if (os.contains("Windows")) {
            home += "\\Resources\\";
        }

        String fileLocation = home + fileName;
        int bound = lineCount(fileLocation);
        String result = randomPull(fileLocation, bound);
        return result;

    }

    private int lineCount(String fileLocation) throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileLocation));
        int lines = 0;
        while (reader.readLine() != null) {
            lines++;
        }
        reader.close();

        return lines / 2;
    }

    private String randomPull(String fileLocation, int bound) throws FileNotFoundException {
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

}
