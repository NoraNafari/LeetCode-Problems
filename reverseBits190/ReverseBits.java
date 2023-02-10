package reverseBits190;

public class ReverseBits {

    public static void main(String[] args) {
        //test case
        //expected:1011_0000_0000_0000_0000_0000_0000_0000
        System.out.println(reverseBits(13));
    }

    public static int reverseBits(int n) {
        if (n==0) {
            return 0;
        }

        int result = 0;
        for (int i = 0; i < 32; i++) {
            //shift the result to left by one
            result<<=1;
            //if the current bit and 1 is one then add one to result
            if ((n&1)==1) {
                result+=1;
            }
            //the current bit is taken care of, so we shift n to right by one
            n>>=1;
        }
        return result;
    }
}
