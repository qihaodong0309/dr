package jzoffer;

import model.ListNode;

/**
 * @author qihaodong
 */
public class JzOffer18 {

    /**
     * 递归解决
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) {
            return head.next;
        }
        head.next = deleteNode(head.next, val);
        return head;
    }

    /**
     * 创建头指针法
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode deleteNode2(ListNode head, int val) {
        ListNode result = new ListNode(-1), temp = result;
        result.next = head;
        while (temp.next.val != val) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return result.next;
    }

}
