package interviewbit.graph;

import java.util.*;

public class DijkstrasShortestPath {

    static class Node {

        public int node;
        public int cost;

        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    private final int[] distance;
    private final Set<Integer> settled;
    private final PriorityQueue<Node> queue;

    List<List<Node>> adjList;
    int numVertices;

    public DijkstrasShortestPath(int numVertices) {
        this.numVertices = numVertices;
        this.distance = new int[numVertices];
        settled = new HashSet<>();
        queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
    }

    public void dijkstra(List<List<Node>> adjList, int source) {
        this.adjList = adjList;
        Arrays.fill(distance, Integer.MAX_VALUE);

        queue.add(new Node(source, 0)); // start node has cost 0 associated with it

        distance[0] = 0;

        while(settled.size() != numVertices) {
            if(queue.isEmpty()) return; // base case

            int u = queue.poll().node;
            
            if(settled.contains(u)) continue;
            settled.add(u);
            
            scanNeighbours(u);
        }
    }

    private void scanNeighbours(int u) {
        for(Node neighbour : adjList.get(u)) {
            if(!settled.contains(neighbour.node)) {
                int newDistance = distance[u] + neighbour.cost;
                if(newDistance < distance[neighbour.node]) distance[neighbour.node] = newDistance;
                queue.add(new Node(neighbour.node, distance[neighbour.node]));
            }
        }
    }

    public static void main(String[] args) {
        int V = 5;
        int source = 0;

        // Adjacency list representation of the
        // connected edges by declaring List class object
        // Declaring object of type List<Node>
        List<List<Node> > adj = new ArrayList<>();

        // Initialize list for every node
        for (int i = 0; i < V; i++) {
            List<Node> item = new ArrayList<>();
            adj.add(item);
        }

        // Inputs for the GFG(dpq) graph
        adj.get(0).add(new Node(1, 9));
        adj.get(0).add(new Node(2, 6));
        adj.get(0).add(new Node(3, 12));
        adj.get(0).add(new Node(4, 3));

        adj.get(2).add(new Node(1, 2));
        adj.get(2).add(new Node(3, 4));

        // Calculating the single source shortest path
        DijkstrasShortestPath dpq = new DijkstrasShortestPath(V);
        dpq.dijkstra(adj, source);

        // Printing the shortest path to all the nodes
        // from the source node
        System.out.println("The shorted path from node :");

        for (int i = 0; i < dpq.distance.length; i++)
            System.out.println(source + " to " + i + " is "
                    + dpq.distance[i]);
    }
}
