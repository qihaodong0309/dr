package collection.tree;

import model.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 同 JzOffer 37
 *
 * @author qihaodong
 */
public class LeetCode297 {

    /*
    本题不在于如何序列化和反序列化，只要能保证唯一，怎么搞都可以
     */

    /**
     * 深度优先遍历
     *
     * @param root
     * @return
     */
    public String serialize(TreeNode root) {
        return seEcho(root, "");
    }

    private String seEcho(TreeNode root, String str) {
        if (root == null) {
            str += "None,";
        } else {
            str += root.val + ",";
            str = seEcho(root.left, str);
            str = seEcho(root.right, str);
        }
        return str;
    }

    public TreeNode deserialize(String data) {
        String[] datas = data.split(",");
        List<String> dataList = new LinkedList<>(Arrays.asList(datas));
        return deEcho(dataList);
    }

    private TreeNode deEcho(List<String> ls) {
        if (ls.get(0).equals("None")) {
            ls.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(ls.get(0)));
        ls.remove(0);
        root.left = deEcho(ls);
        root.right = deEcho(ls);
        return root;
    }

}
