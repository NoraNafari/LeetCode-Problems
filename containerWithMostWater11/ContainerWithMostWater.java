package containerWithMostWater11;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        //test case
        int[] heights = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(heights));
    }

    //we have two pointers one in the start and one in the end of the array
    //then we can start iterating through the elements and if we find a column
    //that is higher than the previous one, we switch to it.
    //we also keep the maximum in a variable in order to return it.
    public static int maxArea(int[] height) {
        int leftPointer = 0;
        int rightPointer = height.length-1;
        int maximumArea = 0;

        while (leftPointer<rightPointer) {
            int heightOfContainer = Math.min(height[leftPointer], height[rightPointer]);
            int area = heightOfContainer * (rightPointer-leftPointer);
            maximumArea = Math.max(area, maximumArea);
            if (height[leftPointer]<height[rightPointer]) {
                leftPointer++;
            }
            else {
                rightPointer--;
            }
        }
        return maximumArea;
    }
}
