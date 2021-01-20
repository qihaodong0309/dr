package collection.list;

import model.ListNode;

/**
 * @author qihaodong
 */
public class LeetCode142 {

    /**
     * 快慢指针加数学思路
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode quick = head, slow = head, result = null;
        while (quick != null) {
            quick = quick.next != null ? quick.next.next : null;
            slow = slow.next;
            if (quick != null && quick == slow) {
                result = head;
                while (result != slow) {
                    slow = slow.next;
                    result = result.next;
                }
                break;
            }
        }
        return result;
    }

}
