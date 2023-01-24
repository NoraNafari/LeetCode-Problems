package romanToInteger13;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static void main(String[] args) {
        //test case
        System.out.println(romanToInt("IV"));
    }

    public static int romanToInt(String s) {
        //first we put the characters and the equivalents in a map
        Map<Character, Integer> characterValues = fillMap();
        int result = 0;
        Character prevChar = null;
        //then we iterate through the string starting from the last element
        //The key is to subtract a value if it is smaller than the character on the right-hand side of it
        //otherwise add it to the result
        for (int i = s.length()-1; i >=0; i--) {
            char currentChar = s.charAt(i);
            Integer currentValue = characterValues.get(currentChar);
            if (prevChar!=null) {
                Integer prevValue = characterValues.get(prevChar);
                if (prevValue>currentValue) {
                    result-=currentValue;
                }
                else {
                    result+=currentValue;
                }
            }
            else {
                result+=currentValue;
            }
            prevChar = currentChar;
        }
        return result;
    }

    private static Map<Character, Integer> fillMap() {
        Map<Character, Integer> characterValues = new HashMap<>();
        characterValues.put('I', 1);
        characterValues.put('V', 5);
        characterValues.put('X', 10);
        characterValues.put('L', 50);
        characterValues.put('C', 100);
        characterValues.put('D', 500);
        characterValues.put('M', 1000);
        return characterValues;
    }
}
