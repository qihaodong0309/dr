package jzoffer;

import model.ListNode;

/**
 * 同 LeetCode 160
 *
 * @author qihaodong
 */
public class JzOffer52 {

    /**
     * k 神解法
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;
        while (a != b) {
            a = a != null ? a.next : headB;
            b = b != null ? b.next : headA;
        }
        return a;
    }

}
