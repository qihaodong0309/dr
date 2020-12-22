package map;

import model.TreeNode;

import java.util.*;

/**
 * @author qihaodong
 */
public class LeetCode103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();
        stack.push(root);
        int index = 1;
        while (!stack.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            while (!stack.isEmpty()) {
                TreeNode treeNode = stack.pop();
                list.add(treeNode.val);
                if (index % 2 != 0) {
                    offerTreeNode(queue, treeNode.left);
                    offerTreeNode(queue, treeNode.right);
                } else {
                    offerTreeNode(queue, treeNode.right);
                    offerTreeNode(queue, treeNode.left);
                }
            }
            while (!queue.isEmpty()) {
                stack.push(queue.poll());
            }
            index++;
            result.add(list);
        }
        return result;
    }

    private void offerTreeNode(Queue queue, TreeNode treeNode) {
        if (treeNode != null) {
            queue.offer(treeNode);
        }
    }

}
