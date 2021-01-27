package collection.queue;

import model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 同 JzOffer 32_2
 *
 * @author qihaodong
 */
public class LeetCode102 {

    /**
     * 优化 JzOffer 方法一，对于在遍历过程中会修改集合长度的情况：
     * for(int i = 0;i < xxx.length();i++)
     * 可以修改为：
     * for(int i = xxx.length();i > 0;i--)
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            for (int i = queue.size() - 1; i >= 0; i--) {
                TreeNode node = queue.poll();
                temp.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(temp);
        }
        return result;
    }

}
