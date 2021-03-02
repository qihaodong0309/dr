package jzoffer;

import model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 同 LeetCode 297
 *
 * @author qihaodong
 */
public class JzOffer37 {

    /**
     * 基于队列实现
     *
     * @param root
     * @return
     */
    public String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        StringBuffer sb = new StringBuffer("[");
        Queue<TreeNode> queue = new LinkedList() {{
            add(root);
        }};
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                sb.append(node.val + ",");
                queue.add(node.left);
                queue.add(node.right);
            } else {
                sb.append("null,");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data.equals("[]")) {
            return null;
        }
        String[] strS = data.substring(1, data.length() - 1).split(",");
        TreeNode result = new TreeNode(Integer.parseInt(strS[0]));
        Queue<TreeNode> queue = new LinkedList() {{
            add(result);
        }};
        int index = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!strS[index].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(strS[index]));
                queue.add(node.left);
            }
            index++;
            if (!strS[index].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(strS[index]));
                queue.add(node.right);
            }
            index++;
        }
        return result;
    }

}
