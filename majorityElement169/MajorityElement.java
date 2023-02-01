package majorityElement169;

import java.util.Arrays;

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums01 = new int[] {3,2,3};
        System.out.println(majorityElement(nums01));
        int[] nums02 = new int[] {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums02));
    }

    public static int majorityElement(int[] nums) {
        //if we sort the array, the element in the middle is the answer
        java.util.Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
