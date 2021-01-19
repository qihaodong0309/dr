package jzoffer;

import model.ListNode;

/**
 * @author qihaodong
 */
public class JzOffer24 {

    /**
     * 数学思路
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode quick = head, slow = head, node = null;
        while (quick != null) {
            quick = quick.next;
            slow.next = node;
            node = slow;
            slow = quick;
        }
        return node;
    }

    /**
     * 递归
     *
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

}
