package jzoffer;

import model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author qihaodong
 */
public class JzOffer32_2 {

    /**
     * 基于队列实现
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue1 = new LinkedList() {{
            add(root);
        }};
        Queue<TreeNode> queue2 = new LinkedList<>();
        while (!queue1.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            while (!queue1.isEmpty()) {
                TreeNode node = queue1.poll();
                if (node != null) {
                    temp.add(node.val);
                    queue2.add(node.left);
                    queue2.add(node.right);
                }
            }
            while (!queue2.isEmpty()) {
                queue1.add(queue2.poll());
            }
            if (temp.size() > 0) {
                result.add(temp);
            }
        }
        return result;
    }

    /**
     * 全局变量 + 递归，这里递归实际上借鉴了 dfs 的思想
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        echo(0, root);
        return result;
    }

    List<List<Integer>> result = new ArrayList<>();

    private void echo(int layer, TreeNode node) {
        if (node == null) {
            return;
        }
        if (layer == result.size()) {
            result.add(new ArrayList<>());
        }
        result.get(layer).add(node.val);
        echo(layer + 1, node.left);
        echo(layer + 1, node.right);
    }

}
