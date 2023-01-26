package sqrt69;

public class sqrt {

    public static void main(String[] args) {

        //test case
        System.out.println(mySqrt(5));

        System.out.println(mySqrt(9));
    }

    //You can either use a binary search method or the newton method
    //binary search is much faster than newton's method
    public static int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int left = 1;
        int right = x;
        while (true) {
            //find the middle
            int mid = left + (right - left) / 2;
            //check if you should check the right half
            if (mid > x / mid) {
                right = mid - 1;
            } else {
                //if it's a lower bound to the square
                if (mid + 1 > x / (mid + 1)) {
                    return mid;
                }
                left = mid + 1;
            }
        }
    }

}
