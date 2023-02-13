package longestPalindromeSubstring5;

public class LongestPalindromeSubstring {

    public static void main(String[] args) {
        String s01 = "babad";

        System.out.println(longestPalindrome(s01));

        String s02 = "cbbd";
        System.out.println(longestPalindrome(s02));

        String s03 = "ccc";
        System.out.println(longestPalindrome(s03));
    }

    //we can have two kinds of palindromes, ones with even number of letters and ones with odd number of letters
    //and we check them separately, after that, whichever is longer is chosen
    public static String longestPalindrome(String s) {
        if (s.length() == 0) {
            return "";
        }

        char[] sChars = s.toCharArray();

        int start = 0;
        int end = 0;

        for (int i = 0; i < sChars.length; i++) {
            int len = Math.max(expand(sChars, i, i), expand(sChars, i, i + 1));

            //if the substring which is palindrome, has a bigger length than the previous one
            //we swith the start and end to that substring
            if (len > end - start + 1) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    //expand recursively until either the string ends or the characters of left and right are different
    public static int expand(char[] sChars, int leftPointer, int rightPointer) {
        while (leftPointer >= 0 && rightPointer < sChars.length && sChars[leftPointer] == sChars[rightPointer]) {
            leftPointer--;
            rightPointer++;
        }
        return rightPointer - leftPointer - 1;
    }
}
