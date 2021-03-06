package collection.list;

import model.ListNode;

/**
 * @author qihaodong
 */
public class LeetCode83 {

    /**
     * 一次遍历法
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode result = new ListNode(-1);
        result.next = head;
        ListNode node = result, next = result.next, last = next.next;
        while (last != null) {
            while (last != null && last.val != next.val) {
                node = node.next;
                next = next.next;
                last = last.next;
            }
            if (last == null) {
                break;
            }
            while (last != null && last.val == next.val) {
                last = last.next;
            }
            next.next = last;
            node = next;
            next = node.next;
            last = next == null ? null : next.next;
        }
        return result.next;
    }

}
