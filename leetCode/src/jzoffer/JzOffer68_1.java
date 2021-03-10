package jzoffer;

import model.TreeNode;

/**
 * 同 LeetCode 235
 *
 * @author qihaodong
 */
public class JzOffer68_1 {

    /**
     * 递归判断法
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (isContain(root.left, p) && isContain(root.left, q)) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (isContain(root.right, p) && isContain(root.right, q)) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }

    private boolean isContain(TreeNode root, TreeNode node) {
        if (root == null) {
            return false;
        }
        return root == node || isContain(root.left, node) || isContain(root.right, node);
    }

    /**
     * K神解法 (根据二叉搜索树的性质来计算)
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else {
                break;
            }
        }
        return root;
    }

}
