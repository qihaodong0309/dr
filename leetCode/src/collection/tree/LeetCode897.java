package collection.tree;

import model.TreeNode;

/**
 * @author qihaodong
 */
public class LeetCode897 {

    /**
     * 中序访问
     *
     * @param root
     * @return
     */
    public TreeNode increasingBST(TreeNode root) {
        echo(root);
        return head;
    }

    TreeNode head, pre = null;

    private void echo(TreeNode node) {
        if (node == null) {
            return;
        }
        echo(node.left);
        if (head == null) {
            head = node;
        } else {
            pre.right = node;
        }
        pre = node;
        pre.left = null;
        echo(node.right);
    }

}
