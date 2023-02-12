package longestSubstringWithoutRepeatingCharacters3;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        //test case
        String test01 = "bbbb";
        System.out.println(lengthOfLongestSubstring(test01));

        String test02 = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(test02));

        String test03 = "pwwkew";
        System.out.println(lengthOfLongestSubstring(test03));

        String test04 = "dvdf";
        System.out.println(lengthOfLongestSubstring(test04));

        String test05 = "cdd";
        System.out.println(lengthOfLongestSubstring(test05));

        String test06 = "abba";
        System.out.println(lengthOfLongestSubstring(test06));

    }

    public static int lengthOfLongestSubstring(String s) {
        //keep a map of characters and their last seen positions
        Map<Character, Integer> charMap = new HashMap<>();
        //keep two pointers, one for moving forward and one for the last index of repeated character
        int forwardPointer = 0;
        int lastRepeatingPointer = 0;
        int max = 0;
        while(forwardPointer<s.length()) {
            char currentChar = s.charAt(forwardPointer);
            Integer integer = charMap.get(currentChar);
            if (integer!=null) {
                //in order to exclude the possible repeating character between the previous one and the current one
                lastRepeatingPointer = java.lang.Math.max(integer + 1, lastRepeatingPointer);
                //check if the current string length is the maximum
                max = java.lang.Math.max(max, forwardPointer - lastRepeatingPointer );
            }
            //add the current to check for the next one
            charMap.put(currentChar, forwardPointer);
            forwardPointer++;
            //it may be the longest string up until here!
            max = java.lang.Math.max(max, forwardPointer - lastRepeatingPointer );
        }
        return max;
    }
}
