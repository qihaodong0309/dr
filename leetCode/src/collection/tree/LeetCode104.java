package collection.tree;

import model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 同 JzOffer 55_1
 *
 * @author qihaodong
 */
public class LeetCode104 {

    /**
     * JzOffer 采用深度优先，这里采用广度优先
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int result = 0;
        Queue<TreeNode> queue = new LinkedList() {{
            add(root);
        }}, temp;
        while (!queue.isEmpty()) {
            temp = new LinkedList<>();
            for (TreeNode node : queue) {
                if (node.left != null) {
                    temp.add(node.left);
                }
                if (node.right != null) {
                    temp.add(node.right);
                }
            }
            queue = temp;
            result++;
        }
        return result;
    }

}
