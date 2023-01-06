package maximumIcecreamBars1833;

import java.util.Arrays;

public class MaximumIceCreamBars {

    public static void main(String[] args) {
        //test case
        int[] costs = new int[]{1, 6, 3, 1, 2, 5};
        int coins = 20;

        System.out.println(maxIceCream(costs, coins));
    }

    //Greedy method that sorts the array first and
    //reduce the ice cream costs one by one from total coins that we have
    public static int maxIceCream(int[] costs, int coins) {
        int result = 0;
        Arrays.sort(costs);
        //While we still have money and the next ice cream is costing less than our money
        while (result < costs.length && costs[result] <= coins) {
            coins -= costs[result];
            result++;
        }
        return result;
    }
}
