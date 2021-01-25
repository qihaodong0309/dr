package collection.list;

import model.ListNode;

/**
 * 同 JzOffer24
 *
 * @author qihaodong
 */
public class LeetCode206 {

    /**
     * 递归
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

}
