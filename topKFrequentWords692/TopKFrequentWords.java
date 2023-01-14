package topKFrequentWords692;

import java.util.*;

public class TopKFrequentWords {

    public static void main(String[] args) {

        //test case
        String[] words = new String[] {"i","love","leetcode","i","love","coding"};
        int k = 2;
        topKFrequent(words, k).forEach(System.out::println);

        String[] words2 = new String[] {"the","day","is","sunny","the","the","the","sunny","is","is"};
        int k2 = 4;
        topKFrequent(words2, k2).forEach(System.out::println);
    }

    public static List<String> topKFrequent(String[] words, int k) {
        //Keep the count in a hashmap and insert elements in priority queue alphabetically
        Map<String, Integer> wordsFrequency = new HashMap<>();

        //Add words and frequencies to map
        for (String word : words) {
            wordsFrequency.put(word, wordsFrequency.getOrDefault(word, 0) + 1);
        }

        //Create a priority queue based on conditions for comparing
        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>((o1, o2) ->
                o1.getValue() - o2.getValue() == 0 ? o2.getKey().compareTo(o1.getKey()) : o1.getValue() - o2.getValue());

        //add the elements to the queue and remove if the number of elements exceed k
        for (Map.Entry<String, Integer> stringIntegerEntry : wordsFrequency.entrySet()) {
            queue.offer(stringIntegerEntry);
            if (queue.size()>k) {
                queue.poll();
            }
        }

        List<String> result = new LinkedList<>();

        //add the elements to the first slot of a linked list
        while (!queue.isEmpty()) {
            result.add(0, queue.poll().getKey());
        }

        return result;
    }
}

