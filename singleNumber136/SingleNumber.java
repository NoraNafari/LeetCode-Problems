package singleNumber136;

public class SingleNumber {

    public static void main(String[] args) {
        //test case
        System.out.println(singleNumber(new int[]{1,2,2,1,4}));
    }

    //We have to use XOR operation on the bits of numbers
    //In this way, no matter what the order is, same numbers cross out each other automatically
    //And that's why this bit manipulation work.
    public static int singleNumber(int[] nums) {
        int result = 0;
        for(int i : nums) {
            result ^= i;
        }
        return result;
    }
}
