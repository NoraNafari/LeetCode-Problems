package threeSum15;

import java.util.*;

public class ThreeSum {

    public static void main(String[] args) {

        //test case
        int[] nums01 = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = threeSum(nums01);
        for (List<Integer> list : res) {
            System.out.println("New list");
            for (Integer integer : list) {
                System.out.print(integer + ",");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        //create a set in order to detect duplicates
        Set<List<Integer>> result = new HashSet<>();
        //the result will be empty if size is less than 3
        if (nums.length < 3) {
            return new ArrayList<>(result);
        }
        //first sort the array
        Arrays.sort(nums);

        //check one by one if the numbers fit the constraint
        for (int i = 0; i < nums.length - 2; i++) {
            if(nums[i]>0){
                //the sum will never be zero if the first element becomes positive since the array is sorted
                break;
            }

            //check from the element after i
            int j = i + 1;
            //check from the last element
            int k = nums.length - 1;

            //increase j and decrease k until the two pointers reach each other
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    result.add(List.of(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                } else if (sum > 0) {
                    //it means that we need smaller numbers in order to create zero sum
                    k--;
                } else {
                    j++;
                }
            }
        }
        return new ArrayList<>(result);
    }
}
