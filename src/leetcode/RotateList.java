package leetcode;

public class RotateList {

    /*
        1 -> 2 -> 3 -> 4 -> 5
        length =    0   1   2   3   4   5
        head =      1   2   3   4   5   null

        breakPoint = 3
        node =  1   2   3
        i =         0   1   2   3
    */

    private int lengthOfList(ListNode head) {
        int length = 0;
        while(head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    public ListNode rotateRight(ListNode head, int rot) {
        int listSize = lengthOfList(head);
        if(listSize == 0) return head;
        rot %= listSize;
        if(rot == 0) return head;
        int breakPoint = listSize - rot;
        ListNode node = head;
        for(int i = 0; i < breakPoint - 1; ++i) node = node.next;
        ListNode lastNode = node;
        while(lastNode.next != null) lastNode = lastNode.next;

        ListNode newHead = node.next;
        node.next = null;
        lastNode.next = head;
        return newHead;
    }
}
