package jzoffer;

import model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author qihaodong
 */
public class JzOffer34 {

    /**
     * 递归
     *
     * @param root
     * @param sum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        if (root.val == sum && root.left == null && root.right == null) {
            List<Integer> list = new LinkedList() {{
                add(sum);
            }};
            result.add(list);
            return result;
        }
        List<List<Integer>> lRes = pathSum(root.left, sum - root.val);
        List<List<Integer>> rRes = pathSum(root.right, sum - root.val);
        for (List<Integer> list : lRes) {
            LinkedList<Integer> linkedList = (LinkedList) list;
            linkedList.addFirst(root.val);
            result.add(linkedList);
        }
        for (List<Integer> list : rRes) {
            LinkedList<Integer> linkedList = (LinkedList) list;
            linkedList.addFirst(root.val);
            result.add(linkedList);
        }
        return result;
    }

    /**
     * dfs + 回溯
     * 使用全局变量优化上述代码，上述代码采用dfs
     *
     * @param root
     * @param sum
     * @return
     */
    public List<List<Integer>> pathSum2(TreeNode root, int sum) {
        echo(root, sum);
        return result;
    }

    List<List<Integer>> result = new LinkedList<>();
    LinkedList<Integer> temp = new LinkedList<>();

    private void echo(TreeNode node, int sum) {
        if (node == null) {
            return;
        }
        temp.add(node.val);
        sum = sum - node.val;
        if (sum == 0 && node.left == null && node.right == null) {
            result.add(new LinkedList<>(temp));
        }
        echo(node.left, sum);
        echo(node.right, sum);
        temp.removeLast();
    }

}
