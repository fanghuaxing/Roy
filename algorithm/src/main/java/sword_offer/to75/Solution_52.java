package sword_offer.to75;


import sword_offer.ListNode;

public class Solution_52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode index1 = headA;
        ListNode index2 = headB;
        while (index1 != index2) {
            index1 = index1 == null ? headB : index1.next;
            index2 = index2 == null ? headA : index2.next;
        }
        return index1;
    }

}

