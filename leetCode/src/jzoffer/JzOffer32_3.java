package jzoffer;

import model.TreeNode;

import java.util.*;

/**
 * @author qihaodong
 */
public class JzOffer32_3 {

    /**
     * 基于栈 + 队列
     * 栈用来控制方向，队列用来保存中间状态
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<TreeNode> stack = new Stack() {{
            add(root);
        }};
        int record = 0;
        while (!stack.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                if (node != null) {
                    list.add(node.val);
                    queue.add(node);
                }
            }
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (record % 2 == 0) {
                    stack.add(node.left);
                    stack.add(node.right);
                } else {
                    stack.add(node.right);
                    stack.add(node.left);
                }
            }
            record++;
            if (list.size() > 0) {
                result.add(list);
            }
        }
        return result;
    }

    /**
     * 按层遍历，对于偶数行倒序
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList() {{
            add(root);
        }};
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if (node != null) {
                    list.add(node.val);
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
            if (result.size() % 2 == 1) {
                Collections.reverse(list);
            }
            if (list.size() > 0) {
                result.add(list);
            }
        }
        return result;
    }

    /**
     * 使用双向链表，分离遍历逻辑，
     * 这里要注意使用 addLast()、addFirst()。直接使用 add() 会造成取队首时报错
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder3(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        if (root != null) {
            deque.add(root);
        }
        while (!deque.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            for (int i = deque.size(); i > 0; i--) {
                TreeNode node = deque.removeFirst();
                list.add(node.val);
                if (node.left != null) {
                    deque.addLast(node.left);
                }
                if (node.right != null) {
                    deque.addLast(node.right);
                }
            }
            result.add(list);
            if (deque.isEmpty()) {
                break;
            }
            list = new ArrayList<>();
            for (int i = deque.size(); i > 0; i--) {
                TreeNode node = deque.removeLast();
                list.add(node.val);
                if (node.right != null) {
                    deque.addFirst(node.right);
                }
                if (node.left != null) {
                    deque.addFirst(node.left);
                }
            }
            result.add(list);
        }
        return result;
    }

    /**
     * 除了可以让 Queue 做队列，也可以让存结果的数字链表做队列
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder4(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if (result.size() % 2 == 1) {
                    list.addFirst(node.val);
                } else {
                    list.addLast(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(list);
        }
        return result;
    }

}
