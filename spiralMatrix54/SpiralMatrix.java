package spiralMatrix54;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static void main(String[] args) {

        //test case 1
//        [[1,2,3],[4,5,6],[7,8,9]]
        int[][] matrix01 = new int[3][3];
        matrix01[0] = new int[]{1,2,3};
        matrix01[1] = new int[]{4,5,6};
        matrix01[2] = new int[]{7,8,9};
        //expected: [1,2,3,6,9,8,7,4,5]
        List<Integer> res = spiralOrder(matrix01);
        for (Integer integer :
                res) {
            System.out.println(integer);
        }
        //test case 2
        //[[1,2,3,4],[5,6,7,8],[9,10,11,12]]
        int[][] matrix02 = new int[3][4];
        matrix02[0] = new int[] {1,2,3,4};
        matrix02[1] = new int[] {5,6,7,8};
        matrix02[2] = new int[] {9,10,11,12};
        //expected: [1,2,3,4,8,12,11,10,9,5,6,7]
        List<Integer> res2 = spiralOrder(matrix02);
        for (Integer integer :
                res2) {
            System.out.println(integer);
        }
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        //first create the result list
        List<Integer> result = new ArrayList<>();

        //Edge case when nothing is in matrix
        if (matrix==null || matrix.length==0) {
            return result;
        }
        //We use the four walls method, considering one pointer for each wall
        //You can imagine the matrix as a four walled room in your head!
        int leftWallPointer = 0;
        int rightWallPointer = matrix[0].length - 1;
        int topWallPointer = 0;
        int bottomWallPointer = matrix.length - 1;

        //count of total elements
        int totalElements = (rightWallPointer+1) * (bottomWallPointer+1);
        //counter to check whether we have iterated all elements or not. When the counter reaches totalElement,
        //it's time to break from the outer named loop
        int counter = 0;
        //create a named loop. We'll break out of this when the counter reaches total elements.
        //Please note that we have to check if the counter reached the amount of total elements BEFORE we add an element to the result list.
        myLoop:
        while (counter<totalElements) {
            //We iterate through the top row, increasing the counter from left to right
            for (int i = leftWallPointer; i <= rightWallPointer; i++) {
                if (isCounterExceeded(counter, totalElements)) {
                    break myLoop;
                }
                counter++;
                result.add(matrix[topWallPointer][i]);
            }
            //Increase the top wall pointer after it is iterated
            topWallPointer++;
            //Iterate through the right wall pointer, starting from top wall until reaching the bottom wall.
            //Please note that we already checked the upper-right most element in the previous loop.
            for (int j = topWallPointer; j <=bottomWallPointer; j++) {
                if (isCounterExceeded(counter, totalElements)) {
                    break myLoop;
                }
                counter++;
                result.add(matrix[j][rightWallPointer]);
            }
            //Decrease the right wall pointer after its iterated (because the right wall starts at the right-most end of the matrix
            // and continues to the top)
            rightWallPointer--;
            //Iterate through the bottom wall, starting from right to left.
            for (int k = rightWallPointer; k>=leftWallPointer; k--) {
                if (isCounterExceeded(counter, totalElements)) {
                    break myLoop;
                }
                counter++;
                result.add(matrix[bottomWallPointer][k]);
            }
            //decrease the bottom wall pointer
            bottomWallPointer--;
            //finally, we check the leftmost wall
            for (int m = bottomWallPointer; m>=topWallPointer; m--) {
                if (isCounterExceeded(counter, totalElements)) {
                    break myLoop;
                }
                counter++;
                result.add(matrix[m][leftWallPointer]);
            }
            //and increase the left wall pointer
            leftWallPointer++;
        }
        return result;
    }

    private static Boolean isCounterExceeded(Integer counter, Integer totalElements) {
        return counter>=totalElements;
    }

}
