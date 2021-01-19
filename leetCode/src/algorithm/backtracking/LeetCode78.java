package algorithm.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qihaodong
 */
public class LeetCode78 {

    public static void main(String[] args) {
        LeetCode78 test = new LeetCode78();
        List<List<Integer>> list = test.subsets(new int[]{1, 2, 3, 1});
        System.out.println("xxx");
    }

    /**
     * 依次循环
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        if (nums == null || nums.length == 0) {
            return result;
        }
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> temp = new ArrayList<>();
            for (List<Integer> list : result) {
                List<Integer> newList = copyList(list);
                newList.add(nums[i]);
                if (!isContain(result, newList)) {
                    temp.add(newList);
                }
            }
            result.addAll(temp);
        }
        return result;
    }

    private List<Integer> copyList(List<Integer> list) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            result.add(list.get(i));
        }
        return result;
    }

    private boolean isContain(List<List<Integer>> lists, List<Integer> list1) {
        for (List<Integer> list : lists) {
            if (list.size() == list1.size()) {
                boolean judge = true;
                for (int i = 0; i < list.size(); i++) {
                    if (!list.get(i).equals(list1.get(i))) {
                        judge = false;
                        break;
                    }
                }
                if (judge) {
                    return true;
                }
            }
        }
        return false;
    }

    List<Integer> temp = new ArrayList();
    List<List<Integer>> result = new ArrayList();

    /**
     * dfs
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets2(int[] nums) {
        dfs(0, nums);
        return result;
    }

    private void dfs(int index, int[] nums) {
        if (index == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[index]);
        dfs(index + 1, nums);
        temp.remove(temp.size() - 1);
        dfs(index + 1, nums);
    }

    /**
     * 基于位运算
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets3(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        List<Integer> temp = new ArrayList();
        int n = nums.length;
        for (int i = 0; i < (1 << n); i++) {
            temp.clear();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    temp.add(nums[j]);
                }
            }
            result.add(new ArrayList<>(temp));
        }
        return result;
    }

}