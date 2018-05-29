package task1;

import java.util.HashMap;

public class Task1 {

    public static HashMap<Character, Integer> findLettersFrequency(String source){
        HashMap<Character, Integer> result = new HashMap<>();

        for (int i = 97; i <= 122; i++) {
            result.put((char)i, 0);
        }


        String lowerCaseString = source.toLowerCase();
        char [] chars = lowerCaseString.toCharArray();

        for (char character : chars){
            if(result.containsKey(character)) {
                result.put(character, result.get(character) + 1);
            }
//            result.merge(character, 1, Integer::sum);
        }

        return result;
    }

    public static int findLetterFrequency(String source, Character letter){
        return findLettersFrequency(source).get(letter);
    }
}