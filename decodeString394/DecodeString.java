package decodeString394;

import java.util.Stack;

public class DecodeString {

    public static void main(String[] args) {

        //test case
        System.out.println(decodeString("3[a2[c]]"));
    }

    public static String decodeString(String s) {
        //to keep the string that is going to be repeated
        String resultingString = "";
        //to keep the number of times that a string is going to be repeated
        Stack<Integer> countStack = new Stack<>();
        //to keep track of nested strings that are going to be repeated
        Stack<String> stringStack = new Stack<>();

        int counter = 0;
        while (counter < s.length()) {
            if (Character.isDigit(s.charAt(counter))) {
                int count = 0;
                //if the count is more than one digit, you have to create the number
                while (Character.isDigit(s.charAt(counter))) {
                    count = 10 * count + (s.charAt(counter) - '0');
                    counter++;
                }
                countStack.push(count);
            }
            //when one string finishes and the other starts
            else if (s.charAt(counter) == '[') {
                stringStack.push(resultingString);
                resultingString = "";
                counter++;
            }
            //when a string finishes
            else if (s.charAt(counter) == ']') {
                StringBuilder temp = new StringBuilder (stringStack.pop());
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(resultingString);
                }
                resultingString = temp.toString();
                counter++;
            }
            else {
                //add the character to the temporary string
                resultingString += s.charAt(counter++);
            }
        }
        return resultingString;
    }
}
