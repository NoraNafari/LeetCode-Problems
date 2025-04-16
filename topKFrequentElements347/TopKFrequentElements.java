package topKFrequentElements347;

import java.util.*;

public class TopKFrequentElements {

    public static void main(String[] args) {
        int[] nums = new int[] {1,1,1,2,2,3};
        int[] result = topKFrequent(nums, 2);
        Arrays.asList(result).forEach(System.out::println);
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> frequencyMap.get(b) - frequencyMap.get(a));
        maxHeap.addAll(frequencyMap.keySet());
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll();
        }
        return result;

    }
}
