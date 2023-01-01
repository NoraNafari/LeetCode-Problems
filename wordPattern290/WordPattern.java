package wordPattern290;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public static void main(String... args) {
        //Test case
        String chars = "abba";
        String words = "dog dog dog dog";
        System.out.println(wordPattern(chars, words));
    }

    public static boolean wordPattern(String pattern, String s) {
        //In order to compare the pattern with string s,
        //We have to change them into arrays, and check them one by one.
        char[] charactersOfPattern = pattern.toCharArray();
        String[] words = s.split(" ");
        //Edge case: If the two are not the same in size, Then they are not matched.
        if (charactersOfPattern.length!=words.length) {
            return false;
        }
        //We have to keep a map of already checked characters to check the recurring <character,word> pair
        Map<Character, String> checkedCharacters = new HashMap<>();
        //and we have to have another map for recurring <word,character> pair
        Map<String, Character> checkedWords = new HashMap<>();
        for (int i = 0; i < charactersOfPattern.length; i++) {
            char currentChar = charactersOfPattern[i];
            String currentWord = words[i];
            //Check if the character was observed previously
            if (checkedCharacters.containsKey(currentChar)) {
                String mappedString = checkedCharacters.get(currentChar);
                //if the character occurred before, the word must be the same as previous occurrence
                if (!mappedString.equals(currentWord)) {
                    return false;
                }
            }
            if (checkedWords.containsKey(currentWord)) {
                //if the word occurred before, it must be mapped to the same character
                Character mappedCharacter = checkedWords.get(currentWord);
                if (mappedCharacter!=currentChar) {
                    return false;
                }
            }
            //To keep track of the characters and words, we add them to the maps
            checkedCharacters.put(currentChar, currentWord);
            checkedWords.put(currentWord, currentChar);
        }
        return true;
    }
}