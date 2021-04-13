package collection.tree;

import model.TreeNode;

/**
 * @author qihaodong
 */
public class LeetCode783 {

    int pre = -1, result = Integer.MAX_VALUE;

    /**
     * 根据全局变量 + 中序遍历
     *
     * @param root
     * @return
     */
    public int minDiffInBST(TreeNode root) {
        echo(root);
        return result;
    }

    private void echo(TreeNode root) {
        if (root == null) {
            return;
        }
        echo(root.left);
        if (pre != -1) {
            result = Math.min(result, root.val - pre);
        }
        pre = root.val;
        echo(root.right);
    }

}
