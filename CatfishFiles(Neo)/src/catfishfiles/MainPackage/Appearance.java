package catfishfiles.MainPackage;

import java.io.Serializable;


/**
 * @author basilGeorge9oulose
 * @Date 16th May 2019
 *
 * An entire class dedicated to formatting the text in the windows. like adding
 * strikethroughs, putting it in box, underlines and so on. For visual purposes.
 *
 *
 */
public class Appearance {

    static char cornerCharacter;

    private void topBottom(int length) {
        /**
         * draws the top and bottom lines for the putInBox function
         */
        System.out.print(cornerCharacter);
        for (int i = 0; i <= length + 1; i++) {
            System.out.print("-");
        }
        System.out.println(cornerCharacter);
    }

    public void putInBox(String line, char cornerCharacter) {
        /**
         * Takes a string and puts it in a box made of '-' and '|' with
         * cornerCharacters used for the corners of the box
         */
        this.cornerCharacter = cornerCharacter;
        int length = 0;
        String s = "";

        if (line != null) {
            s = line;
        } else {
            s = "ERROR 619 - failed to fetch text!";
        }
        if (s.length() > length) {
            length = s.length();
        }

        topBottom(length);
        int spaces = length - s.length();
        System.out.print("| " + s);
        while (spaces-- > 0) {
            System.out.print(" ");
        }
        System.out.println(" |");
        topBottom(length);
    }

    public String strikethrough(String str, int limit, char... patternCharacter) {
        /**
         * Takes a string and draws a patten made of characters passed to it,
         * before and after the string
         *
         * eg. =-=-=-=- Example =-=-=-=-
         */
        String result = "";
        result += drawStrikethrough(limit, patternCharacter);
        result += " " + str + " ";
        result += drawStrikethrough(limit, patternCharacter);
        return result;
    }

    private String drawStrikethrough(int limit, char... patternCharacter) {

        /**
         * Returns the strikethrough pattern characters arranged in order as a
         * String
         */
        String result = "";
        while (limit > 0) {
            for (char c : patternCharacter) {
                result += c;
            }
            limit--;
        }
        return result;
    }

    public void underLine(String str, char c) {
        /**
         * Used to underline a String with characters passed as c
         */
        int length = str.length() + 2;

        System.out.println(" " + str);
        while (length > 0) {
            System.out.print(c);
            length--;
        }
        System.out.println();
    }
}
