package collection.list;

import model.ListNode;

/**
 * @author qihaodong
 */
public class LeetCode61 {

    /**
     * 快慢指针法
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode quick = head, slow = head, result = null, end = null;
        for (int i = 1; i <= k; i++) {
            quick = quick.next == null ? head : quick.next;
        }
        if (quick == slow) {
            return head;
        }
        while (quick.next != null) {
            quick = quick.next;
            slow = slow.next;
        }
        result = slow.next;
        slow.next = null;
        end = quick;
        end.next = head;
        return result;
    }

    /**
     * 传统方法
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight2(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode result = null, temp = head;
        int length = 1;
        for (; temp.next != null; length++) {
            temp = temp.next;
        }
        temp.next = head;
        temp = head;
        for (int i = 1; i <= length - (k % length) - 1; i++) {
            temp = temp.next;
        }
        result = temp.next;
        temp.next = null;
        return result;
    }

}
