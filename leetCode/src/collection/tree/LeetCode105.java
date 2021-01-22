package collection.tree;

import model.TreeNode;

import java.util.Stack;

/**
 * 本题同 JzOffer 7
 *
 * @author qihaodong
 */
public class LeetCode105 {

    /**
     * 使用 栈 加迭代
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree3(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode result = new TreeNode(preorder[0]);
        Stack<TreeNode> stack = new Stack();
        stack.push(result);
        int length = preorder.length, inIndex = 0;
        for (int i = 1; i < length; i++) {
            int leftVal = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inIndex]) {
                node.left = new TreeNode(leftVal);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inIndex]) {
                    node = stack.pop();
                    inIndex++;
                }
                node.right = new TreeNode(leftVal);
                stack.push(node.right);
            }
        }
        return result;
    }

}
