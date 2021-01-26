package jzoffer;

import model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author qihaodong
 */
public class JzOffer28 {

    /**
     * 基于队列（效率非常低）
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.add(root);
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            Queue<TreeNode> temp1 = queue1.isEmpty() ? queue2 : queue1;
            Queue<TreeNode> temp2 = queue1.isEmpty() ? queue1 : queue2;
            TreeNode[] nodes = new TreeNode[temp1.size()];
            int index = 0;
            while (!temp1.isEmpty()) {
                TreeNode node = temp1.poll();
                nodes[index++] = node;
                if (node != null) {
                    temp2.add(node.left);
                    temp2.add(node.right);
                }
            }
            if (!judge(nodes)) {
                return false;
            }
        }
        return true;
    }

    private boolean judge(TreeNode[] nodes) {
        int n = nodes.length;
        if (n != 1 && n % 2 == 1) {
            return false;
        }
        for (int i = 0; i < n / 2; i++) {
            int val1 = nodes[i] == null ? -1001 : nodes[i].val;
            int val2 = nodes[n - i - 1] == null ? -1001 : nodes[n - i - 1].val;
            if (val1 != val2) {
                return false;
            }
        }
        return true;
    }

    /**
     * 递归判断
     *
     * @param root
     * @return
     */
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        }
        return echo(root.left, root.right);
    }

    private boolean echo(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return echo(left.left, right.right) && echo(left.right, right.left);
    }

}
