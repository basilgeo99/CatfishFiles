package catfishfiles.MainPackage.FileOps;

import catfishfiles.MainPackage.Player;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import jxl.write.WriteException;
import java.util.Scanner;
import java.io.File;
import java.util.concurrent.TimeUnit;

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

    ExcelRW excelObject = new ExcelRW();


    /*
        THE BELOW DEFINED ENUM IS USED SO THAT THE SAME CLASS CAB BE USED FOR BOTH
            save AND  resource  FOLDER ACESS DEPENDING ON WHICH ENUM VALUE ID PASSED.
     */
    public enum FileType {
        SAVE,
        RESOURCE,
        ART
    }

    public void printArt(String fileName) throws IOException, InterruptedException {
        String home = ResourceDirectory(FileType.ART);
        String fileLocation = home + fileName;
        FileReader filereader = new FileReader(fileLocation);
        try (BufferedReader bufferedReader = new BufferedReader(filereader)) {
            String line = bufferedReader.readLine();
            while (line != null) {
                System.out.println(line);
                 TimeUnit.MILLISECONDS.sleep(100);
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }

    }

    public String RandomDialogue(String fileName) throws IOException {

        String home = ResourceDirectory(FileType.RESOURCE);
        String fileLocation = home + fileName;
        int bound = lineCount(fileLocation);
        Random R = new Random();
        int i = R.nextInt(bound);
        FileReader filereader = new FileReader(fileLocation);
        try (BufferedReader bufferedReader = new BufferedReader(filereader)) {
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

    public String ResourceDirectory(FileType type) throws IOException {
        String os = System.getProperty("os.name");
        String directory = System.getProperty("user.dir");  // variable stores user working directory
        String folder = "";

        if (type.equals(FileType.RESOURCE)) {
            folder = "resources";
        } else if (type.equals(FileType.SAVE)) {
            folder = "saves";
        } else if (type.equals(FileType.ART)) {
            folder = "art";
        }

        if (os.contains("Linux")) {
            directory += "/Files/" + folder + "/";
        } else if (os.contains("Windows")) {
            directory += "\\Files\\" + folder + "\\";
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

    public void SaveGame(Player P) throws IOException, WriteException {
        String output = ResourceDirectory(FileType.SAVE) + P.name + ".xls";
        excelObject.setOutputFile(output);
        excelObject.write(P);
    }

    public Player LoadGame(Player P) throws IOException {

        String inputPathString = ResourceDirectory(FileType.SAVE) + P.name + ".xls";
        File f = new File(inputPathString);
        if (f.exists() && !f.isDirectory()) {
            System.out.print("A player with the same name already exists. Load game? [Y/N]: ");
            Scanner sc = new Scanner(System.in);
            char ch = sc.next().charAt(0);
            if (ch == 'y' || ch == 'Y') {
                ExcelRW test = new ExcelRW();
                test.setOutputFile(inputPathString);
                test.read(P);
            }
        }
        return P;
    }

    public void SaveObject(Player P) throws IOException {
        String output = ResourceDirectory(FileType.SAVE) + P.name + ".sav";
        ObjectIO Obj = new ObjectIO();
        Obj.writeObject(P, output);
    }

    public Player LoadObject(Player P) throws IOException, FileNotFoundException, ClassNotFoundException {
        String input = ResourceDirectory(FileType.SAVE) + P.name + ".sav";

        File f = new File(input);
        if (f.exists() && !f.isDirectory()) {
            System.out.print("A player with the same name already exists. Load game? [Y/N]: ");
            Scanner sc = new Scanner(System.in);
            char ch = sc.next().charAt(0);
            if (ch == 'y' || ch == 'Y') {
                ObjectIO Obj = new ObjectIO();
                P = Obj.readObject(input);
            }
        }

        return P;
    }

}
