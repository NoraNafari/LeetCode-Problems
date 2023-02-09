package intersectionOfTwoArrays350;

import java.util.*;

public class IntersectionOfTwoArrays {

    public static void main(String[] args) {

    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        //first we add the numbers and frequency of occurrence in a map
        Map<Integer, Integer> mapOfElements = new HashMap<>();

        for (int i = 0; i < nums1.length; i++) {
            mapOfElements.put(nums1[i], mapOfElements.getOrDefault(nums1[i], 0)+1);
        }
        //then we start comparing the numbers in the second array to the numbers in the map
        //if it exists, it means that the number is an intersection
        //we subtract one unit from the frequency each time  we visit an element
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            Integer freq = mapOfElements.get(nums2[i]);
            if (freq!=null && freq >0) {
                result.add(nums2[i]);
                mapOfElements.put(nums2[i], freq-1);
            }
        }
        //converting a list to an array
        int[] resArr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resArr[i] = result.get(i);
        }
        return resArr;
    }
}
