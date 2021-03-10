package collection.tree;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 同 JzOffer 68_1
 *
 * @author qihaodong
 */
public class LeetCode235 {

    /**
     * K神解法 (递归法)
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        return root;
    }

    /**
     * 官方解法
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> list1 = getPath(root, p);
        List<TreeNode> list2 = getPath(root, q);
        TreeNode result = null;
        for (int i = 0; i < list1.size() && i < list2.size(); i++) {
            if (list1.get(i) == list2.get(i)) {
                result = list1.get(i);
            } else {
                break;
            }
        }
        return result;
    }

    private List<TreeNode> getPath(TreeNode root, TreeNode node) {
        List<TreeNode> result = new ArrayList<>();
        TreeNode temp = root;
        while (temp != node) {
            result.add(temp);
            if (node.val < temp.val) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        result.add(temp);
        return result;
    }

}
