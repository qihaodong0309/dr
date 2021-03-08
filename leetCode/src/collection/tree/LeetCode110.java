package collection.tree;

import model.TreeNode;

/**
 * 同 JzOffer 55_2
 *
 * @author qihaodong
 */
public class LeetCode110 {

    /**
     * K 神解法（递归根据高度判断）
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        return echo(root) != -1;
    }

    private int echo(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = echo(root.left), right = echo(root.right);
        if (left == -1 || right == -1) {
            return -1;
        }
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }
}
