package jzoffer;

import model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author qihaodong
 */
public class JzOffer32_1 {

    /**
     * 基于队列实现
     *
     * @param root
     * @return
     */
    public int[] levelOrder(TreeNode root) {
        List<Integer> list = new ArrayList();
        Queue<TreeNode> queue1 = new LinkedList();
        Queue<TreeNode> queue2 = new LinkedList();
        queue1.add(root);
        while (!queue1.isEmpty()) {
            while (!queue1.isEmpty()) {
                TreeNode node = queue1.poll();
                if (node != null) {
                    list.add(node.val);
                    queue2.add(node.left);
                    queue2.add(node.right);
                }
            }
            while (!queue2.isEmpty()) {
                TreeNode node = queue2.poll();
                if (node != null) {
                    queue1.add(node);
                }
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * 优化上述方法一，我傻逼了
     *
     * @param root
     * @return
     */
    public int[] levelOrder2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList() {{
            add(root);
        }};
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                list.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

}
