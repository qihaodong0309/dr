package jzoffer;

import model.TreeNode;

/**
 * @author qihaodong
 */
public class JzOffer54 {

    /**
     * K神解法：中序遍历
     *
     * @param root
     * @param k
     * @return
     */
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return result;
    }

    int result, k;

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.right);
        if (k == 0) {
            return;
        }
        if (--k == 0) {
            result = node.val;
        }
        dfs(node.left);
    }

}
