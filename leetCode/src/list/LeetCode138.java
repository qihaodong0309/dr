package list;

import model.Node;

import java.util.HashMap;

/**
 * @author qihaodong
 */
public class LeetCode138 {

    /**
     * 基于 HashMap
     * 时间复杂度 O(N)，空间复杂度 O(n)
     *
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        HashMap<Node, Node> map = new HashMap(16);
        Node echo = head;
        while (echo != null) {
            Node temp = echo;
            map.put(temp, new Node(temp.val));
            echo = echo.next;
        }
        echo = head;
        while (echo != null) {
            Node temp = map.get(echo);
            temp.next = map.get(echo.next);
            temp.random = map.get(echo.random);
            echo = echo.next;
        }
        return map.get(head);
    }

    /**
     * 空间复杂度优化
     *
     * @param head
     * @return
     */
    public Node copyRandomList2(Node head) {
        if (head == null) {
            return null;
        }
        Node start = head;
        while (start != null) {
            Node next = new Node(start.val);
            next.next = start.next;
            start.next = next;
            start = next.next;
        }
        start = head;
        while (start != null) {
            start.next.random = (start.random != null) ? start.random.next : null;
            start = start.next.next;
        }
        Node old = head, fresh = head.next, result = head.next;
        while (old != null) {
            old.next = old.next.next;
            fresh.next = fresh.next == null ? null : fresh.next.next;
            old = old.next;
            fresh = fresh.next;
        }
        return result;
    }

}
