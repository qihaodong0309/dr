package jzoffer;

import model.ListNode;

/**
 * @author qihaodong
 */
public class JzOffer22 {

    /**
     * 双指针法
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode result = head, record = head;
        while (k > 0) {
            record = record.next;
            k--;
        }
        while (record != null) {
            result = result.next;
            record = record.next;
        }
        return result;
    }

}
