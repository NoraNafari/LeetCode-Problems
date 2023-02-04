package containsDuplicate217;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[] {1, 2, 3, 1}));
        System.out.println(containsDuplicate(new int[] {1, 2, 3}));
    }

    //we use a set to detect duplicates
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> numsUnique = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (numsUnique.contains(nums[i])) {
                return true;
            }
            numsUnique.add(nums[i]);
        }
        return false;
    }
}
