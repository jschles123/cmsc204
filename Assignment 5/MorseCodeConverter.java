import java.util.HashMap;

public class MorseCodeConverter {

    public static MorseCodeTree MorseCodeTree = new MorseCodeTree();
    public static HashMap<String,String> MorseCodeMap= new HashMap<>();
    public static String[] letterList = {
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O",
            "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
            "1", "2", "3", "4", "5", "6", "7", "8", "9", "0"
    };
    public static String[] codeList = {
            ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---",
            ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..",
            ".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.", "-----"
    };

    public static void fillMap(){
        for(int i=0;i<letterList.length;i++){
            MorseCodeMap.put(letterList[i],codeList[i]);
        }
    }

    public MorseCodeConverter() {
        MorseCodeConverter.fillMap();
    }


    public static String convertToEnglish(String s) {
        String[] words = s.split(" ");
        String english = "";
        for(String word : words) {
            if(!word.equals("/")) {
                english += MorseCodeConverter.MorseCodeTree.fetch(word);
            }else{
                english += " ";
            }
        }
        return english;
    }
}
