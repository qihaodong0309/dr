package collection.tree;

import model.TreeNode;

import java.util.Stack;

/**
 * @author qihaodong
 */
public class LeetCode872 {

    /**
     * 采用遍历的方法
     *
     * @param root1
     * @param root2
     * @return
     */
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        return getLeafList(root1).equals(getLeafList(root2));
    }

    /**
     * 采用栈模拟前序遍历
     *
     * @param node
     * @return
     */
    public String getLeafList(TreeNode node) {
        StringBuffer result = new StringBuffer();
        Stack<TreeNode> stack = new Stack<>();
        if (node != null) {
            stack.push(node);
        }
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            if (temp == null) {
                continue;
            }
            if (temp.left == null && temp.right == null) {
                result.append(temp.val + "#");
            }
            stack.push(temp.right);
            stack.push(temp.left);
        }
        return result.toString();
    }

    public boolean leafSimilar2(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        getLeafList2(root1, sb1);
        getLeafList2(root2, sb2);
        return sb1.toString().equals(sb2.toString());
    }

    /**
     * 递归实现
     *
     * @param node
     * @return
     */
    public void getLeafList2(TreeNode node, StringBuilder sb) {
        if (node.left == null && node.right == null) {
            sb.append(node.val);
            sb.append("#");
        } else {
            if (node.left != null) {
                getLeafList2(node.left, sb);
            }
            if (node.right != null) {
                getLeafList2(node.right, sb);
            }
        }
    }

}
