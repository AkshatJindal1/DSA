package leetcode;

public class RemoveDuplicatesInSortedList2 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode ans = new ListNode(0, head);
        ListNode prev = ans;

        while(head != null) {
            if(head.next != null && head.val == head.next.val) {
                while(head.next != null && head.val == head.next.val) head = head.next;
                prev.next = head.next;
            } else prev = prev.next;
            head = head.next;
        }
        return ans.next;
    }

    public static void main(String[] args) {
    }
}
