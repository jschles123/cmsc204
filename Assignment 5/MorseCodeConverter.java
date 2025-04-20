import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Utility class for converting Morse code to English text and interacting with the Morse code tree.
 * Uses a static instance of MorseCodeTree to perform conversions and output.
 *
 * @author Joshua Schlesinger-Guevara
 */
public class MorseCodeConverter {

    /**
     * Static Morse code tree used for conversions.
     */
    public static MorseCodeTree tree = new MorseCodeTree();

    /**
     * Default constructor for MorseCodeConverter.
     */
    public MorseCodeConverter() {

    }

    /**
     * Converts a string of Morse code into English.
     * Morse code words are separated by " / ".
     *
     * @param s Morse code string to convert
     * @return English representation of the Morse code
     */
    public static String convertToEnglish(String s) {
        String[] words = s.split(" ");
        String english = "";
        for(String word : words) {
            if(!word.equals("/")) {
                english += MorseCodeConverter.tree.fetch(word);
            }else{
                english += " ";
            }
        }
        return english;
    }

    /**
     * Converts Morse code stored in a file into English.
     * Only the first line of the file is read.
     *
     * @param s File containing Morse code
     * @return English translation of the Morse code
     * @throws FileNotFoundException If the file is not found
     */
    public static String convertToEnglish(File s) throws FileNotFoundException {
        try {
            BufferedReader br = new BufferedReader(new FileReader(s));
            String line = br.readLine();
            br.close();
            return MorseCodeConverter.convertToEnglish(line);
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Returns a string of all the elements in the Morse code tree in in-order traversal.
     *
     * @return Space-separated string of letters in in-order from the Morse code tree
     */
    public static String printTree() {
        ArrayList<String> list = MorseCodeConverter.tree.toArrayList();
        String output = "";
        for(String word : list) {
            output += word + " ";

        }
        if(output.length() > 1) {
            return output.substring(0, output.length() - 1);
        }
        return output;
    }
}
