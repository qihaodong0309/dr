package algorithm.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qihaodong
 */
public class LeetCode46 {

    /**
     * dps , 回溯
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        int[] record = new int[nums.length];
        dfs(result, new ArrayList<Integer>(), nums, record);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> list, int[] nums, int[] record) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (record[i] == 0) {
                record[i] = 1;
                list.add(nums[i]);
                dfs(result, list, nums, record);
                list.remove(list.size() - 1);
                record[i] = 0;
            }
        }
    }

}
