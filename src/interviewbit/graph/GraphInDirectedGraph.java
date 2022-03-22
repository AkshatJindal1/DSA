package interviewbit.graph;

import java.util.*;

public class GraphInDirectedGraph {
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        boolean visited[] = new boolean[A + 1];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(ArrayList<Integer> list: B) {
            graph.computeIfAbsent(list.get(0), x -> new ArrayList<>()).add(list.get(1));
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        while(!queue.isEmpty()) {
            int top = queue.poll();
            if(top == A) return 1;
            if(visited[top]) continue;
            visited[top] = true;
            List<Integer> neighbours = graph.getOrDefault(top, new ArrayList<>());
            for(int x : neighbours) {
                if(!visited[x]) queue.add(x);
            }
        }
        return 0;
    }

    ArrayList<ArrayList<Integer>> convert(int[][] matrix) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int[] arr : matrix) {
            ArrayList<Integer> list = new ArrayList<>();
            for(int i : arr) list.add(i);
            ans.add(list);
        }
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph = new GraphInDirectedGraph().convert(new int[][]{{1, 2},
        {4, 1},
            {2, 4},
                {3, 4},
                    {5, 2},
                        {1, 3}});
        System.out.println(new GraphInDirectedGraph().solve(5, graph));
        System.out.println(new GraphInDirectedGraph().solve(5, new GraphInDirectedGraph().convert(new int[][]{{1, 2},
        {2, 3},
            {3, 4},
                {4, 5}})));
    }
}
