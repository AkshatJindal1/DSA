package leetcode;

import java.util.*;

public class ReachableNodesInSubdividedGraph {
    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        int[] dis = new int[n];
        /*
        * vec contains array of list of nodes reachable from given node from 0 to n
        * each element of a list is a array with two element 1: node ID 2: distance from parent i.e. array index
        * Initializing distance of all nodes from 0 as inf
        * */
        List<int[]>[] vec = new List[n];

        for(int i = 0; i < n; ++i) {
            vec[i] = new ArrayList<>();
            dis[i] = Integer.MAX_VALUE;
        }

        for(int[] arr: edges) {
            vec[arr[0]].add(new int[]{arr[1], arr[2] + 1});
            vec[arr[1]].add(new int[]{arr[0], arr[2] + 1});
        }

        int ans = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        dis[0] = 0;

        /*
        * Calculating the minimum distance of all nodes from zero and modifying dis array
        * */
        while(!queue.isEmpty()) {
            int id = queue.poll();
            for(int[] arr: vec[id]) {
                if(dis[arr[0]] > dis[id] + arr[1]) {
                    dis[arr[0]] = dis[id] + arr[1];
                    queue.offer(arr[0]);
                }
            }
        }

        // adding all initial nodes reachable from zero
        for(int i = 0; i < n; ++i) if(dis[i] <= maxMoves) ans++;

        for(int[] arr : edges) {
            int left = Math.max(0, maxMoves - dis[arr[0]]);
            int right = Math.max(0, maxMoves - dis[arr[1]]);
            ans += Math.min(arr[2],  left + right);
        }
        return ans;
    }

    public static void main(String[] args) {
        ReachableNodesInSubdividedGraph ob = new ReachableNodesInSubdividedGraph();
        int[][] edges = {{0,1,10},{0,2,1},{1,2,2}};
        System.out.println(ob.reachableNodes(edges, 6, 3));
    }
}
