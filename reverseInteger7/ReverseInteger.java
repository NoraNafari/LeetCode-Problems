package reverseInteger7;

public class ReverseInteger {

    public static void main(String[] args) {
        //test case
        System.out.println(reverse(534));
    }


    public static int reverse(int x) {
        int result = 0;

        //get the remaining value of division to 10
        //get the division result to 10
        //repeat the process while the remainder of the division is greater than 10

        while (x != 0) {
            int remainder = x % 10;
            int newResult = result * 10 + remainder;
            //in order to check for overflow of integer
            if ((newResult - remainder) / 10 != result) {
                return 0;
            }
            result = newResult;
            x = x / 10;
        }
        return result;

    }
}
