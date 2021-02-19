package algorithm.bfs;

import model.TreeNode;

import java.util.*;

/**
 * 同 JzOffer 34
 *
 * @author qihaodong
 */
public class LeetCode113 {

    List<List<Integer>> result = new LinkedList<>();
    Map<TreeNode, TreeNode> map = new HashMap<>();

    /**
     * 这里采用 BFS，JzOffer中采用 DFS
     *
     * @param root
     * @param targetSum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue1 = new LinkedList() {{
            add(root);
        }};
        Queue<Integer> queue2 = new LinkedList() {{
            add(0);
        }};
        while (!queue1.isEmpty()) {
            TreeNode node = queue1.poll();
            int val = queue2.poll() + node.val;
            if (node.left == null && node.right == null) {
                if (val == targetSum) {
                    getPath(node);
                }
            } else {
                if (node.left != null) {
                    map.put(node.left, node);
                    queue1.offer(node.left);
                    queue2.offer(val);
                }
                if (node.right != null) {
                    map.put(node.right, node);
                    queue1.offer(node.right);
                    queue2.offer(val);
                }
            }
        }
        return result;
    }

    private void getPath(TreeNode node) {
        LinkedList<Integer> list = new LinkedList<>();
        while (node != null) {
            list.addFirst(node.val);
            node = map.get(node);
        }
        result.add(list);
    }

}
