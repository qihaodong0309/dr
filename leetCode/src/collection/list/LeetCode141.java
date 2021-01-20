package collection.list;

import model.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author qihaodong
 */
public class LeetCode141 {

    /**
     * 快慢指针法
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode quick = head, slow = head;
        while (quick != null) {
            quick = quick.next != null ? quick.next.next : null;
            slow = slow.next;
            if (quick != null && quick == slow) {
                return true;
            }
        }
        return false;
    }

    /**
     * hash 表
     *
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode head) {
        Set<ListNode> set = new HashSet();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }

}
