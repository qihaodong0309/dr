package jzoffer;

import model.TreeNode;

/**
 * 同 LeetCode 104
 *
 * @author qihaodong
 */
public class JzOffer55_1 {

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

}
