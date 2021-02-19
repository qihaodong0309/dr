package jzoffer;

import model.Node;

/**
 * @author qihaodong
 */
public class JzOffer35 {

    /**
     * 不需要使用额外空间的解法
     *
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        Node node = head;
        while (node != null) {
            Node next = new Node(node.val);
            next.next = node.next;
            node.next = next;
            node = next.next;
        }
        node = head;
        while (node != null) {
            node.next.random = node.random == null ? null : node.random.next;
            node = node.next.next;
        }
        Node old = head, fresh = head.next, result = fresh;
        while (old != null) {
            old.next = fresh.next;
            fresh.next = fresh.next == null ? null : fresh.next.next;
            old = old.next;
            fresh = fresh.next;
        }
        return result;
    }

}