package jzoffer;

import model.TreeNode;

/**
 * @author qihaodong
 */
public class JzOffer26 {

    /**
     * 递归判断法
     *
     * @param A
     * @param B
     * @return
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        if (A.val == B.val && isEqual(A, B)) {
            return true;
        }
        return isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean isEqual(TreeNode node1, TreeNode node2) {
        if (node2 == null) {
            return true;
        }
        if (node1 == null) {
            return false;
        }
        if (node1.val == node2.val) {
            return isEqual(node1.left, node2.left) && isEqual(node1.right, node2.right);
        }
        return false;
    }


}
