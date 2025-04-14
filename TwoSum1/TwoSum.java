package TwoSum1;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int[] array = {0,4,3,0};
        int target = 0;
        int[] ints = twoSum(array, target);
        Arrays.stream(ints).forEach(System.out::println);
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
