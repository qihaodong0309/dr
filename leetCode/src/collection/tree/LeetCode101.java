package collection.tree;

import model.TreeNode;

/**
 * 同 JzOffer28
 *
 * @author qihaodong
 */
public class LeetCode101 {

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
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
