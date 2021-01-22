package jzoffer;

import model.ListNode;

import java.util.Stack;

/**
 * @author qihaodong
 */
public class JzOffer6 {

    /**
     * 使用栈来记录
     *
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        int[] result = new int[stack.size()];
        int index = 0;
        while (!stack.isEmpty()) {
            result[index++] = stack.pop().val;
        }
        return result;
    }

    /**
     * 记录长度
     *
     * @param head
     * @return
     */
    public int[] reversePrint2(ListNode head) {
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            length++;
        }
        temp = head;
        int[] result = new int[length];
        for (int i = length - 1; i >= 0; i--, temp = temp.next) {
            result[i] = temp.val;
        }
        return result;
    }

}
