package jzoffer;

import model.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author qihaodong
 */
public class JzOffer7 {

    /**
     * 递归，分别模拟前序下标和中序下标的范围
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        return echo(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode echo(int[] pre, int[] in, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        TreeNode result = new TreeNode(pre[preStart]);
        for (int mid = inStart; mid <= inEnd; mid++) {
            if (in[mid] == pre[preStart]) {
                result.left = echo(pre, in, preStart + 1, preStart + mid - inStart, inStart, mid - 1);
                result.right = echo(pre, in, preStart + mid - inStart + 1, preEnd, mid + 1, inEnd);
                break;
            }
        }
        return result;
    }

    /**
     * 上述递归方法可以优化，通过 map 存储下表，省去遍历查找的过程
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        int length = preorder.length;
        Map<Integer, Integer> map = new HashMap(length);
        for (int i = 0; i < length; i++) {
            map.put(inorder[i], i);
        }
        return echo(preorder, inorder, 0, length - 1, 0, length - 1, map);
    }

    private TreeNode echo(int[] pre, int[] in, int preStart, int preEnd, int inStart, int inEnd, Map<Integer, Integer> map) {
        if (preStart > preEnd) {
            return null;
        }
        TreeNode result = new TreeNode(pre[preStart]);
        if (preStart != preEnd) {
            int mid = map.get(pre[preStart]), left = mid - inStart;
            result.left = echo(pre, in, preStart + 1, preStart + left, inStart, mid - 1, map);
            result.right = echo(pre, in, preStart + left + 1, preEnd, mid + 1, inEnd, map);
        }
        return result;
    }

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
