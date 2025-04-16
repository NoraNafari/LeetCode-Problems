package groupAnagram49;

import java.util.*;

public class GroupAnagram {

    public static void main(String[] args) {
        String[] strings = {"","b",""};
        List<List<String>> lists = groupAnagrams(strings);
        for (List<String> list : lists) {
            System.out.println("new list");
            for (String str : list) {
                System.out.println(str);
            }
        }
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
