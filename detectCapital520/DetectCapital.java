package detectCapital520;

import java.util.HashSet;
import java.util.Set;

import static java.lang.Character.isUpperCase;

public class DetectCapital {

    public static void main(String[] args) {
        //test case
        String word = "USA";
        System.out.println(detectCapitalUse(word));
    }

    //Three conditions must be met
    //cond1: Only first uppercase
    //cond2: All uppercase
    //cond3: All lowercase
    public static boolean detectCapitalUse(String word) {
        //In order to check the string we have to check all the characters
        char[] chars = word.toCharArray();
        Set<Integer> allUpperPositions = new HashSet<>();
        //Iterate through the alphabet and check for uppercase letters
        for (int i = 0; i < chars.length; i++) {
            char currentChar = chars[i];
            boolean isUpperCase = isUpperCase(currentChar);
            if (isUpperCase) {
                //To break the loop if an upper case letter occurs somewhere between all the letters
                if (i!=0 && allUpperPositions.size()!=i) {
                    return false;
                }
                //Add the upper case to a set in order to check in the last part
                allUpperPositions.add(i);
            }
        }
        //if no uppercases
        return allUpperPositions.size()==0 ||
                //if all upper case
                allUpperPositions.size()==chars.length ||
                //this condition will only reach of all are uppercase except the last one
                (allUpperPositions.size()==1 && allUpperPositions.contains(0));
    }
}
