package collection.list;

import model.ListNode;

/**
 * @author qihaodong
 */
public class LeetCode2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(-1), temp = result;
        int num = 0, next = 0;
        while (l1 != null && l2 != null) {
            num = l1.val + l2.val + next;
            next = num >= 10 ? 1 : 0;
            num = num >= 10 ? num % 10 : num;
            temp.next = new ListNode(num);
            temp = temp.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            num = l1.val + next;
            next = num >= 10 ? 1 : 0;
            num = num >= 10 ? num % 10 : num;
            temp.next = new ListNode(num);
            temp = temp.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            num = l2.val + next;
            next = num >= 10 ? 1 : 0;
            num = num >= 10 ? num % 10 : num;
            temp.next = new ListNode(num);
            temp = temp.next;
            l2 = l2.next;
        }
        if (next != 0) {
            temp.next = new ListNode(next);
        }
        return result.next;
    }

    /**
     * 上述代码优化
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(-1), temp = result;
        int num = 0, next = 0;
        while (l1 != null || l2 != null || next != 0) {
            int i = l1 == null ? 0 : l1.val;
            int j = l2 == null ? 0 : l2.val;
            num = i + j + next;
            next = num >= 10 ? 1 : 0;
            num = num >= 10 ? num % 10 : num;
            temp.next = new ListNode(num);
            temp = temp.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        return result.next;
    }

}
