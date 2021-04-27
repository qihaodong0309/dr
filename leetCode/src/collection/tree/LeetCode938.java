package collection.tree;

import model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author qihaodong
 */
public class LeetCode938 {

    /**
     * 递归
     *
     * @param root
     * @param low
     * @param high
     * @return
     */
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        } else if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        } else {
            return root.val + rangeSumBST(root.right, low, high) + rangeSumBST(root.left, low, high);
        }
    }

    /**
     * BFS
     *
     * @param root
     * @param low
     * @param high
     * @return
     */
    public int rangeSumBST2(TreeNode root, int low, int high) {
        int result = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode t = queue.poll();
            if (t == null) {
                continue;
            }
            if (t.val > high) {
                queue.offer(t.left);
            } else if (t.val < low) {
                queue.offer(t.right);
            } else {
                result += t.val;
                queue.offer(t.left);
                queue.offer(t.right);
            }
        }
        return result;
    }

}
