package validPalindrome125;

public class ValidPalindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
    }

    //We use a two-pointer method in order to validate the string
    public static boolean isPalindrome(String s) {
        int startingPointer = 0;
        int endingPointer = s.length()-1;
        s = s.toLowerCase();
        //starting pointer is at the start and ending pointer is in the end
        //continue until two pointers reach each other
        while (startingPointer<endingPointer) {
            char b = s.charAt(startingPointer);
            char c = s.charAt(endingPointer);

            if (!Character.isLetterOrDigit(b)) {
                startingPointer++;
            }
            else if (!Character.isLetterOrDigit(c)) {
                endingPointer--;
            }
            else {
                if (b!=c) {
                    return false;
                }
                else {
                    startingPointer++;
                    endingPointer--;
                }
            }
        }
        return true;
    }
}
