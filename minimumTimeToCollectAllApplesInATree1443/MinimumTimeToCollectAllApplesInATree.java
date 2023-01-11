package minimumTimeToCollectAllApplesInATree1443;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumTimeToCollectAllApplesInATree {

    public static void main(String[] args) {
        //test case
//        [0,1],[0,2],[1,4],[1,5],[2,3],[2,6]
        int[][] edges = new int[][]{new int[]{0,1}, new int[]{0,2}, new int[]{1,4}, new int[]{1,5}, new int[]{2,3}, new int[]{2,6}};
        List<Boolean> hasApple = List.of(false,false,true,false,false,true,false);
        int n = 7;
        System.out.println(minTime(n, edges, hasApple));
    }

    //We have to check a node and it's children for apples.
    //So we have to traverse the tree completely
    //since each edge must be traversed twice, we have to add 2 for the time needed to traverse it.
    //First we have to keep track of nodes and its adjacent element (parent and children)
    public static int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        // construct the graph as a map
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int[] currentEdge = edges[i];
            int i1 = currentEdge[0];
            int i2 = currentEdge[1];
            graph.computeIfAbsent(i1, integer -> new ArrayList<>()).add(i2);
            graph.computeIfAbsent(i2, integer -> new ArrayList<>()).add(i1);
        }
        //we run a dfs on the map
        return dfs(0, -1, graph, hasApple);
    }

    public static int dfs(int child, int parent, Map<Integer, List<Integer>> map, List<Boolean> hasApple) {
        if (!map.containsKey(child)) {
            return 0;
        }

        //check each child of the graph recursively to see if any apples exist
        List<Integer> children = map.get(child);
        int totalTime = 0;
        int childTime = 0;
        for (Integer integer : children) {
            if (integer==parent) {
                continue;
            }
            childTime+=dfs(integer, child, map, hasApple);
            if (childTime>0 || hasApple.get(child)) {
                totalTime+=childTime+2;
            }
        }
        return totalTime;
    }


}
