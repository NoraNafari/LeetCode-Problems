package minimumRoundsToCompleteAllTasks2244;

import java.util.HashMap;
import java.util.Map;

public class MinimumRoundsToCompleteAllTasks {

    public static void main(String[] args) {
        //test case
        int[] test = new int[] {2,2,3,3,2,4,4,4,4,4};
        System.out.println(minimumRounds(test));
    }

    public static int minimumRounds(int[] tasks) {
        //Keep a counter for the ways of grouping the tasks
        int counter = 0;
        //Keep a map of frequency of numbers
        Map<Integer, Integer> numberOccurrenceMap = new HashMap<>();
        //Add frequency of numbers to a map
        for (int currentTask : tasks) {
            numberOccurrenceMap.put(currentTask, numberOccurrenceMap.getOrDefault(currentTask, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry:
        numberOccurrenceMap.entrySet()){
            Integer value = entry.getValue();
            //in there is only one occurrence of any element, the tasks cannot be grouped
            if (value == 1) {
                return - 1;
            }
            if (value % 3 == 0) {
                // Group all the task in triplets.
                counter += value / 3;
            } else {
                // If count % 3 = 1; (count / 3 - 1) groups of triplets and 2 pairs.
                // If count % 3 = 2; (count / 3) groups of triplets and 1 pair.
                counter += value / 3 + 1;
            }
        }
        return counter;

    }
}
