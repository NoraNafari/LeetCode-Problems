package stringToInteger8;

public class StringToInteger {

    public static void main(String[] args) {

        //test case
        System.out.println(myAtoi("42"));
        System.out.println(myAtoi("   -42"));
        System.out.println(myAtoi("4193 with words"));
        System.out.println(myAtoi("words with 973"));
    }

    public static int myAtoi(String s) {
        //remove whitespaces
        s = s.trim();
        //check if string is empty
        if (s.length() == 0) {
            return 0;
        }
        int sign = 1;
        int start = 0;
        long sum = 0;
        //check for sign
        if (s.charAt(0) == '+') {
            start++;
        } else if (s.charAt(0) == '-') {
            sign = -1;
            start++;
        }

        for (int i = start; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return (int) sum * sign;
            }
            sum = sum * 10 + s.charAt(i) - '0';
            //check for overflow
            if (sign == 1 && sum > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (sign == -1 && (-1) * sum < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }

        return (int) sum * sign;
    }
}
