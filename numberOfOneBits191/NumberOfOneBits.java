package numberOfOneBits191;

public class NumberOfOneBits {

    public static void main(String[] args) {
        //test
        //n=11 expected=3
        System.out.println(hammingWeight(11));
    }

    public static int hammingWeight(int n) {
        int counter = 0;
        //We simply check from the rightmost digit
        for (int i = 0; i < 32; i++) {
            //and it with one to see if the bit is equal to one or not
            if ((n&1) == 1) {
                counter++;
            }
            //drop the currently checked bit
            n>>=1;
        }
        return counter;
    }
}
