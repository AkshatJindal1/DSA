import java.util.*;

public class MaxAncestor {

    static class Node {
        int val;
        List<Node> children;

        Node(int val) {
            this.val = val;
            children = new ArrayList<>();
        }
    }

    Node tree;


    private Node createTree2(int[][] edges) {
        int parent = edges[0][0];
        Map<Integer, Node> cache = new HashMap<>();
        Map<Integer, List<Integer>> relation = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        for(int[] edge : edges) {
            if(!cache.containsKey(edge[0])) cache.put(edge[0], new Node(edge[0]));
            if(!cache.containsKey(edge[1])) cache.put(edge[1], new Node(edge[1]));

            if(!relation.containsKey(edge[0])) relation.put(edge[0], new ArrayList<>());
            if(!relation.containsKey(edge[1])) relation.put(edge[1], new ArrayList<>());
            relation.get(edge[0]).add(edge[1]);
            relation.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(parent);

        while(!queue.isEmpty()) {
            int n = queue.size();
            for(int i = 0; i < n; ++i) {
                int top = queue.poll();
                Node topNode = cache.get(top);
                visited.add(top);
                for (int children : relation.get(top)) {
                    if(!visited.contains(children)) {
                        topNode.children.add(cache.get(children));
                        queue.add(children);
                    }
                }
            }
        }
        return cache.get(parent);
    }

    private void createTree(int[][] edges) {
        Map<Integer, Node> cache = new HashMap<>();
        tree = new Node(edges[0][0]);
        cache.put(edges[0][0], tree);

        for(int[] edge : edges) {
            if(!cache.containsKey(edge[0])) cache.put(edge[0], new Node(edge[0]));
            if(!cache.containsKey(edge[1])) cache.put(edge[1], new Node(edge[1]));
            cache.get(edge[0]).children.add(cache.get(edge[1]));
        }
    }

    private List<List<Integer>> getMaximumAncestor(Node tree) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(tree, tree.val, ans);
        return ans;
    }

    private void solve(Node node, int maxSoFar, List<List<Integer>> ans) {
        if(node == null) return;
        if(node.children.size() == 0) ans.add(List.of(node.val, Math.max(node.val, maxSoFar)));
        int finalMaxSoFar = Math.max(maxSoFar, node.val);
        node.children.forEach(child -> solve(child, finalMaxSoFar, ans));
    }


    public static void main(String[] args) {
        MaxAncestor ob = new MaxAncestor();
        ob.createTree(new int[][]{{7, 6}, {7, 10}, {7, 5}, {6, 1}, {6, 8}, {6, 12}, {10, 4}, {10, 11}, {5, 3}, {5, 9}});
        System.out.println(ob.getMaximumAncestor(ob.tree));
    }
}
