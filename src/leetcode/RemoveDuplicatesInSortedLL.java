package leetcode;

public class RemoveDuplicatesInSortedLL {

    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        ListNode res = head;
        ListNode prevNode = head;
        head = res.next;
        while(head != null) {
            System.out.println(head.val);
            if(head.val == prevNode.val){
                prevNode.next = head.next;
            } else {
                prevNode = prevNode.next;
            }
            head = head.next;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode ans = deleteDuplicates(
                new ListNode(1,
                new ListNode(1,
                new ListNode(2,
                new ListNode(3,
                new ListNode(3))))));
        while(ans != null) {
            System.out.print(ans.val + " --> ");
            ans = ans.next;
        }
    }
}
