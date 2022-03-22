package interviewbit.graph;

import java.util.*;

public class LargestDistanceBetweenNodesOfTree {
    int n;
    Map<Integer, List<Integer>> adj;
    public int solve(List<Integer> A) {
        n = A.size();
        if(n <= 1) return 0;
        adj = new HashMap<>();

        for(int i = 0; i < n; ++i) {
            if(A.get(i) == -1) continue;
            adj.computeIfAbsent(i, x -> new ArrayList<>()).add(A.get(i));
            adj.computeIfAbsent(A.get(i), x -> new ArrayList<>()).add(i);
        }

        int[] t1 = bfs(0);
        int[] t2 = bfs(t1[0]);
        return t2[1];

    }

    private int[] bfs(int u) {
        int[] dis = new int[n];

        // mark all distance with -1
        Arrays.fill(dis, -1);

        Queue<Integer> q = new LinkedList<>();

        q.add(u);

        // distance of u from u will be 0
        dis[u] = 0;
        while (!q.isEmpty()) {
            int t = q.poll();

            // loop for all adjacent nodes of node-t
            for(int i = 0; i < adj.get(t).size(); ++i) {
                int v = adj.get(t).get(i);

                // push node into queue only if
                // it is not visited already
                if(dis[v] == -1) {
                    q.add(v);
                    // make distance of v, one more
                    // than distance of t
                    dis[v] = dis[t] + 1;
                }
            }
        }

        int maxDis = 0;
        int nodeIdx = 0;

        // get farthest node distance and its index
        for(int i = 0; i < n; ++i) {
            if(dis[i] > maxDis) {
                maxDis = dis[i];
                nodeIdx = i;
            }
        }

        return new int[]{nodeIdx, maxDis};

    }

    public static void main(String[] args) {
        System.out.println(new LargestDistanceBetweenNodesOfTree().solve(Arrays.asList(-1, 0, 0, 0, 3)));
    }
}
