package collection.tree;

import model.TreeNode;

/**
 * 同 JzOffer68_2
 *
 * @author qihaodong
 */
public class LeetCode236 {

    /**
     * 这里我们优化 JzOffer68_2 方法一，向下递归，第一次有解就返回
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        TreeNode result = null;
        result = lowestCommonAncestor(root.left, p, q);
        if (result == null) {
            result = lowestCommonAncestor(root.right, p, q);
        }
        if (result == null && (judge(root, q) && judge(root, p))) {
            result = root;
        }
        return result;
    }

    private boolean judge(TreeNode node, TreeNode index) {
        if (node == null) {
            return false;
        }
        return (node == index) || judge(node.left, index) || judge(node.right, index);
    }

}
