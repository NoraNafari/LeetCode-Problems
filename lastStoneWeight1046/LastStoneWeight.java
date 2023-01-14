package lastStoneWeight1046;

import java.util.PriorityQueue;

public class LastStoneWeight {

    public static void main(String[] args) {

        //test case
        int[] stones = new int[]{1,3};
        System.out.println(lastStoneWeight(stones));
    }

    public static int lastStoneWeight(int[] stones) {
        //First we define a priority queue which compares elements based on their difference
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)-> b - a);
        //add elements to queue
        for (int a : stones) {
            pq.offer(a);
        }
        //Break the stones against each other!
        while (pq.size() > 1) {
            pq.offer(pq.poll() - pq.poll());
        }
        return pq.poll();
    }
}
