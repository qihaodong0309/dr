package collection.tree;

import model.TreeNode;

/**
 * 同 JzOffer27
 *
 * @author qihaodong
 */
public class LeetCode226 {

    /**
     * 优化 JzOffer27 方法一
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode invertLeft = invertTree(root.left);
        TreeNode invertRight = invertTree(root.right);
        root.left = invertRight;
        root.right = invertLeft;
        return root;
    }

}
