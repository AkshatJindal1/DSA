package interviewbit.graph;

import java.util.*;

public class PathWithGoodNodes {

    Map<Integer, List<Integer>> graph;
    boolean[] visited;
    int ans;
    public int solve(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B, int C) {
        graph = new HashMap<>();
        ans = 0;
        for(ArrayList<Integer> list: B) {
            graph.computeIfAbsent(list.get(0), x -> new ArrayList<>()).add(list.get(1));
            graph.computeIfAbsent(list.get(1), x -> new ArrayList<>()).add(list.get(0));
        }
        System.out.println(graph);
        visited = new boolean[graph.size() + 1];
        visited[1] = true;
        util(A, A.get(0), C, 1);
        return ans;
    }

    public void util(ArrayList<Integer> goodNodes, int goodCount, int maxGood, int currentNode) {
        List<Integer> children = graph.getOrDefault(currentNode, new ArrayList<>());
        if(children.isEmpty()) {
            ans++;
            return;
        }
        if(children.size() == 1 && visited[children.get(0)]) {
            ans++;
            return;
        }
        for(int child: children) {
            if(visited[child]) continue;
            visited[child] = true;
            if(goodNodes.get(child - 1) == 1) {
                if(goodCount + 1 <= maxGood) util(goodNodes, goodCount + 1, maxGood, child);
            } else {
                util(goodNodes, goodCount, maxGood, child);
            }
            visited[child] = false;
        }
    }


    ArrayList<ArrayList<Integer>> convertMatrix(int[][] matrix) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int[] arr : matrix) {
            ArrayList<Integer> list = new ArrayList<>();
            for(int i : arr) list.add(i);
            ans.add(list);
        }
        return ans;
    }

    ArrayList<Integer> convertArray(int[] array) {
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i : array) ans.add(i);
        return ans;
    }

    public static void main(String[] args) {
        PathWithGoodNodes ob = new PathWithGoodNodes();
        ArrayList<Integer> goodArray = ob.convertArray(new int[]{1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 11});
        ArrayList<ArrayList<Integer>> graph = ob.convertMatrix(new int[][]{{10, 6}, {3, 2}, {12, 7}, {9, 5}, {2, 1}, {8, 3}, {7, 1}, {4, 2}, {6, 3}, {11, 4}, {5, 3}, {13, 11}});
        System.out.println(ob.solve(goodArray, graph, 7));

    }
}
