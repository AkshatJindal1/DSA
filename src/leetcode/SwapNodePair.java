package leetcode;

public class SwapNodePair {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        return swap(head);
    }

    // l -->  || l.next --> l.next.next ||  ->
    // l -->  || l.next.next --> l.next ||
    private static ListNode swap(ListNode head) {

        if(head != null && head.next != null) {
            ListNode temp = head.next;
            head.next = temp.next;
            temp.next = head;
            head = temp;

            ListNode l = head.next;

            while(l.next != null && l.next.next != null) {
                temp = l.next;
                l.next = temp.next;
                ListNode x = temp.next.next;
                l.next.next = temp;
                temp.next = x;
                l = temp;
            }
        }
        return head;
    }

    public static void printNodes(ListNode l) {
        while(l != null) {
            System.out.print(l.val + " --> ");
            l = l.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode l = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        printNodes(l);
        ListNode ans = swapPairs(l);
        printNodes(ans);
    }
}
