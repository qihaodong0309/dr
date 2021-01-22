package jzoffer;

import model.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author qihaodong
 */
public class JzOffer68_2 {

    /**
     * 递归判断法（效率极低，重复判断很多）
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (judge(root.left, p) && judge(root.left, q)) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (judge(root.right, p) && judge(root.right, q)) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }

    private boolean judge(TreeNode node, TreeNode index) {
        if (node == null) {
            return false;
        }
        return (node == index) || judge(node.left, index) || judge(node.right, index);
    }

    /**
     * 使用全局变量，并采用递归思想
     *
     * @param root
     * @param p
     * @param q
     * @return
     */

    TreeNode result = null;

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        echo(root, p, q);
        return result;
    }

    /**
     * 返回 root 是否 p 或者 q 的祖节点
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    private boolean echo(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean left = echo(root.left, p, q);
        boolean right = echo(root.right, p, q);
        if ((left && right) || ((root.val == p.val || root.val == q.val) && (left || right))) {
            result = root;
        }
        return left || right || (root.val == p.val) || root.val == q.val;
    }

    /**
     * 使用公共变量+创建父节点
     *
     * @param root
     * @param p
     * @param q
     * @return
     */

    Map<Integer, TreeNode> parent = new HashMap();
    Set<TreeNode> set = new HashSet<>();

    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        while (p != null) {
            set.add(p);
            p = parent.get(p.val);
        }
        while (q != null) {
            if (set.contains(q)) {
                return q;
            }
            q = parent.get(q.val);
        }
        return null;
    }

    /**
     * 采用递归的思想完成父节点的保存
     *
     * @param root
     */
    private void dfs(TreeNode root) {
        if (root.left != null) {
            parent.put(root.left.val, root);
            dfs(root.left);
        }
        if (root.right != null) {
            parent.put(root.right.val, root);
            dfs(root.right);
        }
    }

}
