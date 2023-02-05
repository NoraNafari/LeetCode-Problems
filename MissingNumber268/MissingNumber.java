package MissingNumber268;

public class MissingNumber {

    public static void main(String[] args) {
        //test case
        int[] test01 = new int[] {0,1,3};
        System.out.println(missingNumber(test01));
    }

    //We know that the sum of numbers from 1 to n is equal to (n * (n+1))/2
    //so if we reduce the numbers from the sum one by one, the missing number will be what is left
    public static int missingNumber(int[] nums) {
        int length = nums.length;
        int sum = (length * (length+1))/2;
        for (int i = 0; i < length; i++) {
            sum-=nums[i];
        }
        return sum;
    }
}
