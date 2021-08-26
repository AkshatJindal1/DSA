package leetcode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KSortedMerge {
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for(ListNode list: lists) {
            if(list != null) {
                queue.offer(list);
            }
        }
        ListNode ans = new ListNode(0);
        ListNode node = ans;
        while(!queue.isEmpty()) {
            node.next = queue.poll(); // add the top ll in pq as next value
            node = node.next; // assign this next value as new node
            ListNode next = node.next; // get the next element from the ll we just added
            if(next != null) queue.offer(next); // check if not null then add back the one reduced ll back to pq
        }
        return ans.next;
    }
}
