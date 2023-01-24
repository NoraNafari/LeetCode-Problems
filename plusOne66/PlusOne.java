package plusOne66;

public class PlusOne {

    public static void main(String[] args) {
        int[] ints = plusOne(new int[]{2,9,9});
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public static int[] plusOne(int[] digits) {
        //we start from the last characters of the string
        //if it is less than nine then it is incremented by one,
        //if it is 9 then it will change to 0
        for (int i = digits.length-1; i >=0; i--) {
            if (digits[i]<9) {
                digits[i] = digits[i] + 1;
                return digits;
            }
            //otherwise it will become zero
            digits[i]=0;
        }
        //if the loop has no return value, it means that the initial number
        //consisted of only 9s.
        digits = new int[digits.length+1];
        digits[0]=1;
        return digits;
    }
}
