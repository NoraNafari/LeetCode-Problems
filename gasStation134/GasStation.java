package gasStation134;

public class GasStation {

    public static void main(String[] args) {
        //test case
        int[] gas = new int[] {1,2,3,4,5};
        int[] cost = new int[] {3,4,5,1,2};
        System.out.println(canCompleteCircuit(gas, cost));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        //First, if the sum of gas is less than sum of cost,
        //it would not be possible to take a ride over the arrays!
        int totalGas = 0;
        int totalCost = 0;
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }
        if (totalCost > totalGas) {
            return -1;
        }

        //else we have to start from 0 and go forward.
        //if at any point, the cost becomes bigger than gas, we have to increase the index
        //otherwise that index is the answer to the question
        int remainingGas = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            remainingGas = remainingGas + (gas[i] - cost[i]);
            // If remainsGas becomes negative, set start to the next station and reset remainsGas to 0
            if (remainingGas < 0) {
                start = i + 1;
                remainingGas = 0;
            }
        }
        return start;
    }
}
