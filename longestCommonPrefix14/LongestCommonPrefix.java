package longestCommonPrefix14;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        //test case
        String[] strs = new String[]{"abc", "abdf"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        //check edge cases
        if (strs == null || strs.length == 0) {
            return "";
        }
        //for each word, we check if the characters are the same in one index.
        //If not, we return the substring of the first word that we found up to the current index.
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        //when all characters of all words are the same
        return strs[0];
    }
}
