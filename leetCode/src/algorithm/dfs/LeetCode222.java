package algorithm.dfs;

import model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author qihaodong
 */
public class LeetCode222 {

    /**
     * Queue
     *
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int result = 0, temp = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int length = queue.size();
            result += length;
            if (length < temp) {
                break;
            } else {
                for (int i = 0; i < length; i++) {
                    TreeNode t = queue.poll();
                    if (t.left != null) {
                        queue.offer(t.left);
                    }
                    if (t.right != null) {
                        queue.offer(t.right);
                    }
                }
            }
            temp *= 2;
        }
        return result;
    }

    /**
     * BFS
     *
     * @param root
     * @return
     */
    public int countNodes2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int result = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            result += 1;
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return result;
    }

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public int countNodes3(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes3(root.left) + countNodes3(root.right);
    }

    /**
     * dfs + 二分
     *
     * @param root
     * @return
     */
    public int countNodes4(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int level = 0;
        TreeNode node = root;
        while (node.left != null) {
            node = node.left;
            level++;
        }
        int min = 1 << level, max = (1 << (level + 1)) - 1;
        while (min < max) {
            int mid = (max - min + 1) / 2 + min;
            if (exits(root, level, mid)) {
                min = mid;
            } else {
                max = mid - 1;
            }
        }
        return min;
    }

    private boolean exits(TreeNode root, int level, int index) {
        int record = 1 << (level - 1);
        TreeNode node = root;
        while (node != null && record > 0) {
            if ((record & index) == 0) {
                node = node.left;
            } else {
                node = node.right;
            }
            record >>= 1;
        }
        return node != null;
    }

}
