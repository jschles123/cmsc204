import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.Assert.*;

/**
 * Student unit tests for MorseCodeConverter
 * @author Joshua Schlesinger-Guevara
 */

public class MorseCodeConverterTestStudent {

    String eng1 = "i hope this works";
    String eng2 = "please do not fail";
    String mor1 = ".. / .... --- .--. . / - .... .. ... / .-- --- .-. -.- ...";
    String mor2 = ".--. .-.. . .- ... . / -.. --- / -. --- - / ..-. .- .. .-..";
    String alphabet = "abcdefghijklmnopqrstuvwxyz";


    @Test
    public void testConvertToEnglishFile() {
        File file = new File("src/Alphabet.txt");
        try {
            assertEquals(alphabet, MorseCodeConverter.convertToEnglish(file));
        } catch (FileNotFoundException e) {
            fail();
        }
    }

    @Test
    public void testConvertToEnglishString() {
        assertEquals(eng1, MorseCodeConverter.convertToEnglish(mor1));
        assertEquals(eng2, MorseCodeConverter.convertToEnglish(mor2));
    }

    @Test
    public void testPrintTree() {
        assertEquals("h s v i f u e l r a p w j  b d x n c k y t z g q m o", MorseCodeConverter.printTree());
    }
}
