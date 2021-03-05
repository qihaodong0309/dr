package collection.list;

import model.ListNode;

/**
 * 同 JzOffer 52
 *
 * @author qihaodong
 */
public class LeetCode160 {

    /**
     * 快慢指针加数学思路
     * 实际上和 LeetCode142 是完全相同的题，只是换种说法
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode quick = headB, slow = headB, end = headA, result = null;
        while (end.next != null) {
            end = end.next;
        }
        end.next = headA;
        while (quick != null) {
            quick = quick.next != null ? quick.next.next : null;
            slow = slow.next;
            if (quick != null && quick == slow) {
                result = headB;
                while (result != slow) {
                    slow = slow.next;
                    result = result.next;
                }
                break;
            }
        }
        end.next = null;
        return result;
    }

    /**
     * 数学方法
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode node1 = headA, node2 = headB, result = null;
        int record = 0;
        while (node1 != null && node2 != null && record <= 2) {
            result = node1 == node2 ? (result == null ? node1 : result) : result;
            record += node1.next == null ? 1 : 0;
            record += node2.next == null ? 1 : 0;
            node1 = node1.next == null ? headB : node1.next;
            node2 = node2.next == null ? headA : node2.next;
        }
        return result;
    }

    /**
     * 方法二代码优化，不考虑直接跳转，每次都在末尾 NULL 多走一步，方便跳出循环
     * 方法二实际就是通过 record 参数在不想交的情况下快速跳出循环
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode node1 = headA, node2 = headB;
        while (node1 != node2) {
            node1 = node1 == null ? headB : node1.next;
            node2 = node2 == null ? headA : node2.next;
        }
        return node1;
    }

}
