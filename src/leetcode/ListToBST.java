package leetcode;

public class ListToBST {

    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        ListNode midNode = head;
        ListNode endNode = head;
        ListNode prev = null;
        while(endNode != null && endNode.next != null) {
            endNode = endNode.next.next;
            prev = midNode;
            midNode = midNode.next;
        }
        if(prev == null) head = null;
        else prev.next = null;

        return new TreeNode(midNode.val, sortedListToBST(head), sortedListToBST(midNode.next));

    }

    public ListNode arrayToList(int[] nums) {
        ListNode head = new ListNode();
        ListNode node = head;
        for(int n : nums) {
            node.next = new ListNode(n);
            node = node.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListToBST ltb = new ListToBST();
        System.out.println(ltb.sortedListToBST(ltb.arrayToList(new int[]{-10, -3, 0, 5, 9})));
    }
}
