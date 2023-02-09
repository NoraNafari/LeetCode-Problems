package firstUniqueCharacterInAString387;

public class FirstUniqueCharacterInAString {

    public static void main(String[] args) {
        //test case
        String s1 = "leetcode";
        System.out.println(firstUniqChar(s1));
        String s2 = "loveleetcode";
        System.out.println(firstUniqChar(s2));
        String s3 = "aabb";
        System.out.println(firstUniqChar(s3));
    }

    //We first create an array of character ascii values and increment by one whenever we see a character
    //then we loop again through the characters and see if any of them has the value of 1 in the array
    public static int firstUniqChar(String s) {
        int[] chars = new int[26];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a'] +=1;
        }

        for (int i = 0; i < s.length(); i++) {
            if (chars[s.charAt(i) - 'a']==1) {
                return i;
            }
        }
        return -1;
    }
}
