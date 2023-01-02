package whereWillTheBallFall1704;

public class WhereWillTheBallFall {

    public static void main(String[] args) {

//        test case
//        Input: grid = [[1,1,1,-1,-1],[1,1,1,-1,-1],[-1,-1,-1,1,1],[1,1,1,1,-1],[-1,-1,-1,-1,-1]]
//        Output: [1,-1,-1,-1,-1]
        int[][] grid = new int[5][5];
        grid[0] = new int[]{1, 1, 1, -1, -1};
        grid[1] = new int[]{1, 1, 1, -1, -1};
        grid[2] = new int[]{-1, -1, -1, 1, 1};
        grid[3] = new int[]{1, 1, 1, 1, -1};
        grid[4] = new int[]{-1, -1, -1, -1, -1};
        int[] ball = findBall(grid);
        for (int j : ball) {
            System.out.println(j);
        }
    }

    public static int[] findBall(int[][] grid) {
        int numberOfColumns = grid[0].length;
        int[] result = new int[numberOfColumns];

        //For each row, add the number of column from which the ball comes out. Otherwise -1;
        for (int j = 0; j < numberOfColumns; j++) {
            result[j] = checkRecursively(grid, 0, j);
        }

        return result;
    }

    public static int checkRecursively(int[][] grid, int row, int column) {
        //if we reach the end of rows, we have to return the column number
        if (row == grid.length) {
            return column;
        }

        //if we hit the right and left walls, we're doomed!
        if (column < 0 || column >= grid[0].length) {
            return -1;
        }

        //if the current cell is 1, then the right cell must be 1 too, otherwise it forms a V
        if (grid[row][column] == 1 && column + 1 < grid[0].length && grid[row][column + 1] == 1) {
            //move towards the right-down corner
            return checkRecursively(grid, row + 1, column + 1);
            //if the current cell is -1, then the left cell must be -1 too, otherwise it forms a V
        } else if (grid[row][column] == -1 && column - 1 >= 0 && grid[row][column - 1] == -1) {
            //move towards the left-down corner
            return checkRecursively(grid, row + 1, column - 1);
        }
        return -1;
    }
}
