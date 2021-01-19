package collection.list;

import model.ListNode;

import java.util.PriorityQueue;

/**
 * @author qihaodong
 */
public class LeetCode23 {

    /**
     * 递归解决
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = null;
        int index = -1;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                if (result == null || (lists[i].val < result.val)) {
                    result = lists[i];
                    index = i;
                }
            }
        }
        if (index != -1) {
            lists[index] = lists[index].next;
            result.next = mergeKLists(lists);
        }
        return result;
    }

    /**
     * 借助 LeetCode 21(合并两个链表)，合并 n 次
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode result = lists[0];
        for (int i = 1; i < lists.length; i++) {
            result = mergeTwoLists(result, lists[i]);
        }
        return result;
    }

    /**
     * 优化方法2
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists3(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        int left = 0, right = lists.length - 1;
        while (left < right) {
            int tempLeft = left, tempRight = right;
            while (tempLeft < tempRight) {
                lists[tempLeft] = mergeTwoLists(lists[tempLeft], lists[tempRight]);
                tempLeft++;
                tempRight--;
            }
            right = tempRight;
        }
        return lists[left];
    }

    /**
     * LeetCode 21 方法
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
     * 基于最小堆实现
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists4(ListNode[] lists) {
        for (ListNode node : lists) {
            if (node != null) {
                queue.offer(new TempNode(node.val, node));
            }
        }
        ListNode result = new ListNode(0), temp = result;
        while (!queue.isEmpty()) {
            TempNode tempNode = queue.poll();
            temp.next = tempNode.node;
            temp = temp.next;
            if (tempNode.node.next != null) {
                queue.add(new TempNode(tempNode.node.next.val, tempNode.node.next));
            }
        }
        return result.next;
    }

    PriorityQueue<TempNode> queue = new PriorityQueue<TempNode>();

    class TempNode implements Comparable<TempNode> {

        int val;
        ListNode node;

        TempNode(int val, ListNode node) {
            this.val = val;
            this.node = node;
        }

        @Override
        public int compareTo(TempNode o) {
            return this.val - o.val;
        }
    }

}
