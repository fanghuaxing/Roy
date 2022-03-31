package sword_offer;

public class Solution_22 {

    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null){return head;}
        int count = 1;
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
            count++;
        }
        int index = count - k;
        current = head;
        while (index != 0) {
            current = current.next;
            index--;
        }
        return current;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}




