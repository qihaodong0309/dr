package dps;

import model.TreeNode;

/**
 * @author qihaodong
 */
public class LeetCode124 {

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        getMaxValue(root);
        return max;
    }

    private int getMaxValue(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lVal = Math.max(getMaxValue(root.left), 0);
        int rVal = Math.max(getMaxValue(root.right), 0);
        int temp = root.val + lVal + rVal;
        max = Math.max(max, temp);
        return root.val + Math.max(lVal, rVal);
    }

}
