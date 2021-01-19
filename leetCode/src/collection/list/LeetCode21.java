package collection.list;

import model.ListNode;

/**
 * @author qihaodong
 */
public class LeetCode21 {

    /**
     * 递归
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    /**
     * 正常遍历
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(-1), temp = result;
        while (l1 != null && l2 != null) {
            boolean judge = l1.val <= l2.val;
            temp.next = new ListNode(judge ? l1.val : l2.val);
            temp = temp.next;
            if (judge) {
                l1 = l1.next;
            } else {
                l2 = l2.next;
            }
        }
        temp.next = l2 == null ? l1 : l2;
        return result.next;
    }

}
