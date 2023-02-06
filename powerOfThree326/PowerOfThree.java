package powerOfThree326;

public class PowerOfThree {
    public static void main(String[] args) {
        //test case
        System.out.println(isPowerOfThree(27));
        System.out.println(isPowerOfThree(5));
    }

    public static boolean isPowerOfThree(int n) {
        //in order to check if a number is power of three or not
        //we have to take it  into base 3
        //if it starts with a leading zero and all other digits are zero
        //then it's a power of three
        //then we check the string with a regex (to avoid looping)
        return Integer.toString(n, 3).matches("^10*$");
    }
}
