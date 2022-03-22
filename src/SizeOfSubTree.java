import java.util.*;

public class SizeOfSubTree {
    class Node {
        int value;
        List<Node> children;

        Node(int value) {
            this.value = value;
            children = new ArrayList<>();
        }
    }

    private Node createTree(int[][] edges) {
        if(edges.length == 0) return null;
        Node tree = new Node(edges[0][0]);
        Map<Integer, Node> cache = new HashMap<>();
        cache.put(edges[0][0], tree);
        for(int[] edge : edges) {
            if(!cache.containsKey(edge[0])) cache.put(edge[0], new Node(edge[0]));
            if(!cache.containsKey(edge[1])) cache.put(edge[1], new Node(edge[1]));
            cache.get(edge[0]).children.add(cache.get(edge[1]));
        }
        return tree;
    }

    private final Map<Integer, List<Integer>> newCache = new HashMap<>();
    int time = -1;
    private int createTreeCache(Node tree) {
        if(tree == null) return 0;
        int start = ++time;
        int size = 1;
        for(Node child : tree.children) {
            size += createTreeCache(child);
        }
        int end = ++time;
        newCache.put(tree.value, List.of(size, start, end));
        return size;
    }

    int childTreeSize = 0;
    private int[] getSubTreeSize(Node tree, int[] edge) {
        childTreeSize = 0;
        return new int[]{getTreeSize(tree, edge), childTreeSize};
    }

    private int getTreeSize(Node node, int[] edge) {
        if(node == null) return 0;
        int treeSize = 1;
        for(Node child : node.children) {
            int size = getTreeSize(child, edge);
            if((node.value == edge[0] && child.value == edge[1]) || (node.value == edge[1] && child.value == edge[0])) childTreeSize = size;
            else treeSize += size;
        }
        return treeSize;
    }

//    private List<Integer> removeEdges(Node tree, int[] edge1, int[] edge2) {
//
//        List<Integer> node1 = newCache.get(edge1[0]);
//        List<Integer> node2 = newCache.get(edge1[1]);
//        List<Integer> node3 = newCache.get(edge2[0]);
//        List<Integer> node4 = newCache.get(edge2[1]);
//
//
//
//
//    }

    private int getTreeSizes(Node node, int[][] edges, List<Integer> ans) {
        if(node == null) return 0;

        int treeSize = 1;

        for(Node child : node.children) {
            int size = getTreeSizes(child, edges, ans);
            boolean flag = false;
            for(int[] edge : edges) {
                if ((node.value == edge[0] && child.value == edge[1]) || (node.value == edge[1] && child.value == edge[0])) {
                    ans.add(size);
                    flag = true;
                    break;
                }
            }
            if(!flag) treeSize += size;
        }
        return treeSize;
    }

    class NodeCache {
        Node node;
        Node parent;
        int size;

        NodeCache(Node node, Node parent) {
            this.node = node;
            this.parent = parent;
            size = 1;
        }
    }

    Map<Integer, NodeCache> cache;
    private Node createTreeCache(int[][] edges) {
        if(edges.length == 0) return null;
        Node tree = new Node(edges[0][0]);
        cache = new HashMap<>();

        cache.put(edges[0][0], new NodeCache(tree, null));

        for(int[] edge : edges) {
            if(!cache.containsKey(edge[0]))
                cache.put(edge[0], new NodeCache(new Node(edge[0]), null));
            if(!cache.containsKey(edge[1]))
                cache.put(edge[1],
                    new NodeCache(new Node(edge[1]), cache.get(edge[0]).node));

            cache.get(edge[0]).node.children.add(cache.get(edge[1]).node);
        }
        return tree;
    }

    private void calculateSize(Node node) {
        if(node == null) return;
        if(node.children.size() == 0) return;
        node.children.forEach(child -> calculateSize(child));

        cache.get(node.value).size += node.children
                .stream()
                .map(child -> cache.get(child.value).size)
                .mapToInt(Integer::intValue).sum();
    }

    private int[][] getSubTreeSize(int[][] edges) {
        int[][] ans = new int[edges.length][2];
        int i = 0;
        for(int[] edge : edges) {
            int size1 = cache.get(edge[0]).size;
            int size2 = cache.get(edge[1]).size;
            ans[i][0] = Math.min(size1, size2);
            ans[i][1] = cache.size() - ans[i][0];
            ++i;
        }
        return ans;
    }

    public static void main(String[] args) {
        SizeOfSubTree ob = new SizeOfSubTree();
        Node tree2 = ob.createTree(new int[][]{{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}, {3, 7}, {3, 8}, {5, 9}});

        ob.createTreeCache(tree2);
        System.out.println(ob.newCache);

        System.out.println(Arrays.toString(ob.getSubTreeSize(tree2, new int[]{2, 6})));
//        System.out.println(ob.removeEdges(tree2, new int[][]{{5, 2}, {5, 9}}));
    }

}
