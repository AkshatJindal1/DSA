package leetcode;

import java.util.*;

public class ReconstructItenary {
    // map to store adjacency list of station with their possible destination in sorted order
    private Map<String, List<String>> ticketMap;
    // map to store adjacency list of station with their status of possible destination whether visited or not
    private Map<String, List<Integer>> used;
    // final ans
    private LinkedList<String> ans;

    public List<String> findItinerary(List<List<String>> tickets) {
        ticketMap = new HashMap<>();
        used = new HashMap<>();
        ans = new LinkedList<>();
        // creating adjacency list oof station and destination
        for(List<String> ticket: tickets) {
            if(ticketMap.containsKey(ticket.get(0))) {
                ticketMap.get(ticket.get(0)).add(ticket.get(1));
                used.get(ticket.get(0)).add(1);
            } else {
                List<String> queue = new ArrayList<>();
                queue.add(ticket.get(1));
                ticketMap.put(ticket.get(0), queue);
                List<Integer> list = new ArrayList<>();list.add(1);
                used.put(ticket.get(0), list);
            }
        }
        // sorting the stations
        for(Map.Entry<String, List<String>> entry: ticketMap.entrySet())
            Collections.sort(entry.getValue());

//        System.out.println(ticketMap);
        traverse("JFK", tickets.size() + 1);
        return ans;
    }

    private boolean traverse(String station, int m) {
        // adding the visited station
        ans.add(station);
        System.out.println(ticketMap);
        System.out.println(used);
        System.out.println(ans);
        System.out.println();
        if(ans.size() == m) return true;
        if(ticketMap.containsKey(station)) {
            // iterating over all the available destination from source
            for(int i = 0; i < ticketMap.get(station).size(); ++i) {
                if (used.get(station).get(i) == 1) { // if not visited earlier, visit and go in recursion for next station
                    used.get(station).set(i, 0);
                    if (traverse(ticketMap.get(station).get(i), m)) return true; // if a possible route exists return true
                    used.get(station).set(i, 1); // set back to unvisited for further steps if earlier step did not give valid path
                }
            }
        }
        ans.removeLast(); // remove last added station in case earlier steps did not return a valid path
        return false; // if it comes to this step, valid path was not present, so return false
    }

    public static void main(String[] args) {
        List<List<String>> tickets = Arrays.asList(
                Arrays.asList("JFK","SFO"),
                Arrays.asList("JFK","ATL"),
                Arrays.asList("SFO","ATL"),
                Arrays.asList("ATL","JFK"),
                Arrays.asList("ATL","SFO"));

        System.out.println(new ReconstructItenary().findItinerary(tickets));
    }
}
