package collection.list;

import model.ListNode;

/**
 * @author qihaodong
 */
public class LeetCode92 {

    /**
     * 头插法
     *
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode result = new ListNode(-1), pre = result;
        result.next = head;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next, next;
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return result.next;
    }

}
