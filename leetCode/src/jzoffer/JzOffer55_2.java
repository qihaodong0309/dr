package jzoffer;

import model.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 同 LeetCode 110
 *
 * @author qihaodong
 */
public class JzOffer55_2 {

    /**
     * 递归法
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        initDepth(root);
        return echo(root);
    }

    Map<TreeNode, Integer> map = new HashMap();

    private int initDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = Math.max(initDepth(root.left), initDepth(root.right)) + 1;
        map.put(root, depth);
        return depth;
    }

    private boolean echo(TreeNode root) {
        if (root == null) {
            return true;
        }
        return (Math.abs(map.getOrDefault(root.left, 0) - map.getOrDefault(root.right, 0)) <= 1)
                && echo(root.left) && echo(root.right);
    }

    /**
     * K 神解法 (递归根据高度判断)
     *
     * @param root
     * @return
     */
    public boolean isBalanced2(TreeNode root) {
        return echo2(root) != -1;
    }

    private int echo2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = echo2(root.left), right = echo2(root.right);
        if (left == -1 || right == -1) {
            return -1;
        }
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }

    /**
     * K 神解法（根据高度判断）
     *
     * @param root
     * @return
     */
    public boolean isBalanced3(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(echo3(root.left) - echo3(root.right)) < 2
                && isBalanced3(root.left) && isBalanced3(root.right);
    }

    private int echo3(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(echo3(root.left), echo3(root.right)) + 1;
    }

}
