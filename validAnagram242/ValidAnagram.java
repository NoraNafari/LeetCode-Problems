package validAnagram242;

public class ValidAnagram {

    public static void main(String[] args) {

        //test case:
        String s = "anagram", t = "nagaram";
        System.out.println(isAnagram(s, t));

        String s1 = "rat", t1 = "car";
        System.out.println(isAnagram(s1, t1));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length()!=t.length()) {
            return false;
        }
        //we create an array in which each of the slots represent ascii value of one alphabetical character
        //we add if we see one in s
        //we subtract if we see one in t
        //if all array slots are zero at the end, the strings are anagram
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i)-'a']++;
            alphabet[t.charAt(i)-'a']--;
        }

        for (int j : alphabet) {
            if (j != 0) {
                return false;
            }
        }
        return true;
    }
}
