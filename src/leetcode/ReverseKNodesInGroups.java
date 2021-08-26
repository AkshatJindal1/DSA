package leetcode;

import java.util.Arrays;
import java.util.List;

public class ReverseKNodesInGroups {

    ListNode h;
    ListNode n;

    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        for(ListNode node = head; node != null; count++, node = node.next);
        if(count < k) return  head;
        ListNode prev = rec(head, 0, k, count - count % k);
        prev.next = n;
        return h;
    }

    private ListNode rec(ListNode node, int i, int k, int threshold) {
        if(++i == threshold) {
            h = node;
            n = node.next;
            return node;
        }

        ListNode prev = rec(node.next, i, k, threshold);

        if(i % k == 0) {
            node.next = h;
            prev.next = n;
            h = node;
            n = node.next;
        } else prev.next = node;
        return node;
    }

    int k;

    public ListNode reverseKGroupSimpler(ListNode head, int k) {
        this.k = k;
        int count = 0;
        for(ListNode node = head; node != null; count++, node = node.next);

        List<ListNode> firstSeq = reverse(head, Math.min(k, count));
        ListNode ans = firstSeq.get(0);
        ListNode tail = firstSeq.get(1);
        ListNode next = firstSeq.get(2);
        count -= k;
        while(next != null) {
            List<ListNode> seq = reverse(next, Math.min(k, count));
            ListNode newHead = seq.get(0);
            ListNode newTail = seq.get(1);
            next = seq.get(2);
            tail.next = newHead;
            tail = newTail;
            count -= k;
        }
        return ans;
    }

    private List<ListNode> reverse(ListNode head, int times) {
        if(times < k) return Arrays.asList(head, null, null);
        ListNode newHead = null;
        ListNode tail = head;

        while(head != null && times-- > 0) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return Arrays.asList(newHead, tail, head); // head, tail and next
    }

}
