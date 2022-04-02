package sword_offer.to25;

public class Solution_18 {

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        if (head.val == val) {
            return head.next;
        }
        ListNode pre = head;
        while (pre.next != null){
            if (pre.next.val == val) {
                pre.next = pre.next.next;
                break;
            }else {
                pre = pre.next;
            }
        }
        return head;
    }


    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
