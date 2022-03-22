import java.util.*;

public class MinPathInGraph {

    static class PathCost implements Comparator<PathCost>{
        int cost;
        List<Integer> path;
        PathCost(int cost) {
            this.cost = cost;
            path = new ArrayList<>();
        }
        PathCost(int cost, List<Integer> path) {
            this.cost = cost;
            this.path = path;
        }

        @Override
        public int compare(PathCost o1, PathCost o2) {
            return o1.cost == o2.cost ? o1.path.size() - o2.path.size() : o1.cost - o2.cost;
        }
    }

    private static int findMinPathsToRemoveFast(List<List<Integer>> graph, int start, int end, Set<Integer> blocks) {

        int[] distance = new int[graph.size()];
        boolean[] processed = new boolean[graph.size()];
        for(int i = 0; i < graph.size(); ++i) {
            distance[i] = Integer.MAX_VALUE;
        }

        distance[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{start,0});

        while(!pq.isEmpty()) {
            int[] first = pq.poll();
            processed[first[0]] = true;
            if(first[0] == end) return first[1];
            for(int neighbour : graph.get(first[0])) {
                int cost = blocks.contains(neighbour) ? 1 : 0;
                if(!processed[neighbour] && distance[neighbour] > distance[first[0]] + cost) {
                    distance[neighbour] = distance[first[0]] + cost;
                    pq.add(new int[]{neighbour, distance[neighbour]});
                }
            }
        }
        return -1;
    }

    private static int findMinBlocksToRemove(List<List<Integer>> graph, int start, int end, List<Integer> blocks) {

        PriorityQueue<PathCost> queue = new PriorityQueue<>((a, b) -> a.cost == b.cost ? a.path.size() - b.path.size() : a.cost - b.cost);
        int cost = blocks.contains(start) ? 1 : 0;
        PathCost pathCost = new PathCost(cost);
        pathCost.path.add(start);
        queue.add(pathCost);
        int minCost = Integer.MAX_VALUE;
        int pathLength = Integer.MAX_VALUE;
        while(!queue.isEmpty()) {
            PathCost currentPathCost = queue.poll();
            int last = currentPathCost.path.get(currentPathCost.path.size() - 1);
            if(last == end) {
                if(currentPathCost.cost <= minCost) {
                    minCost = currentPathCost.cost;
                    if(currentPathCost.path.size() < pathLength)
                        pathLength = currentPathCost.path.size();
                }
            }
            for(int neighbour : graph.get(last)) {
                if(!currentPathCost.path.contains(neighbour)) {
                    int newCost = blocks.contains(neighbour) ? currentPathCost.cost + 1 : currentPathCost.cost;
                    if(newCost > minCost) continue;
                    List<Integer> newPath = new ArrayList<>(currentPathCost.path);
                    newPath.add(neighbour);
                    queue.add(new PathCost(newCost, newPath));
                }
            }
        }
        return minCost;
    }

    private static int findMinPathWithBlocks(List<List<Integer>> graph, int start, int end, List<Integer> blocks) {
        if(blocks.contains(start) || blocks.contains(end)) return -1;
        Set<Integer> visited = new HashSet<>(blocks);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);
        int level = 0;
        while(!queue.isEmpty()) {
            int n = queue.size();
            for(int i = 0; i < n; ++i) {
                int first = queue.poll();
                if(first == end) return level;
                for(int neighbour : graph.get(first)) {
                    if(!visited.contains(neighbour)) {
                        if(neighbour == end) return level + 1;
                        queue.add(neighbour);
                    }
                }
            }
            level++;
        }
        return -1;

    }

    private static int minPath(List<List<Integer>> graph, int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        Set<Integer> visited = new HashSet<>();
        visited.add(start);
        int level = 0;
        while(!queue.isEmpty()) {
            int n = queue.size();
            for(int i = 0; i < n; ++i) {
                int first = queue.poll();
                if(first == end) return level;
                for(int neighbour : graph.get(first)) {
                    if(!visited.contains(neighbour)) {
                        if(neighbour == end) return level + 1;
                        queue.add(neighbour);
                        visited.add(neighbour);
                    }
                }
            }
            level++;
        }
        return -1;

    }

    public static void main(String[] args) {
        List<List<Integer>> graph = List.of(List.of(1, 2), List.of(0, 2, 3), List.of(0, 1, 3), List.of(1, 2));
//        System.out.println(minPath(graph, 0, 3));
//        System.out.println(findMinPathWithBlocks(graph, 0, 3, List.of(1)));
//        System.out.println(findMinPathWithBlocks(graph, 0, 3, List.of(1, 2)));

        System.out.println(findMinBlocksToRemove(graph, 0, 3, List.of(1, 2)));
        System.out.println(findMinPathsToRemoveFast(graph, 0, 3, Set.of(1, 2)));

    }
}
