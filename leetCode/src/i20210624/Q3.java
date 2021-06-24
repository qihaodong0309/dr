package i20210624;

import model.ListNode;

/**
 * @author qihaodong
 */
public class Q3 {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = null;
        for (int i = 0; i < lists.length; i++) {
            result = combine(result, lists[i]);
        }
        return result;
    }

    /**
     * 暴力解法
     *
     * @param list1
     * @param list2
     * @return
     */
    private ListNode combine(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode head = new ListNode(-1);
        ListNode temp = head, x = list1, y = list2;
        while (x != null && y != null) {
            if (x.val < y.val) {
                temp.next = x;
                x = x.next;
            } else {
                temp.next = y;
                y = y.next;
            }
            temp = temp.next;
        }
        temp.next = x == null ? y : x;
        return head.next;
    }

}
