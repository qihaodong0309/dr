package jzoffer;

/**
 * 同 LeetCode 426(VIP)
 *
 * @author qihaodong
 */
public class JzOffer36 {

    /**
     * 中序遍历解决 + 全局变量
     *
     * @param root
     * @return
     */
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        echo(root);
        temp.right = head.right;
        head.right.left = temp;
        return head.right;
    }

    Node head = new Node(-1);
    Node temp = head;

    private void echo(Node root) {
        if (root == null) {
            return;
        }
        echo(root.left);
        temp.right = root;
        root.left = temp;
        temp = root;
        echo(root.right);
    }

    class Node {

        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

}
