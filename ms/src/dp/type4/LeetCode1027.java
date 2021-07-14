package dp.type4;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qihaodong
 */
public class LeetCode1027 {

    public static void main(String[] args) {
        LeetCode1027 test = new LeetCode1027();
        test.longestArithSeqLength2(new int[]{3, 6, 9, 12});
    }

    /**
     * dp
     *
     * @param nums
     * @return
     */
    public int longestArithSeqLength(int[] nums) {
        int result = 2, n = nums.length;
        int[][] record = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                record[i][j] = nums[i] - nums[j];
            }
        }
        Map<Integer, Integer> dp = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            for (int j = i - 1; j >= 0; j--) {
                int index = contains(record[j], j, nums[i] - nums[j]);
                if (index >= 0) {
                    int num = dp.getOrDefault(j * n + index, 2);
                    result = Math.max(result, num + 1);
                    dp.put(i * n + j, num + 1);
                }
            }
        }
        return result;
    }

    private int contains(int[] num, int end, int k) {
        for (int i = end - 1; i >= 0; --i) {
            if (num[i] == k) {
                return i;
            }
        }
        return -1;
    }

    /**
     * dp
     *
     * @param nums
     * @return
     */
    public int longestArithSeqLength2(int[] nums) {
        int result = 0, n = nums.length;
        Map<Integer, Map<Integer, Integer>> dp = new HashMap();
        for (int i = 0; i < n; ++i) {
            dp.put(i, new HashMap<>());
            for (int j = i - 1; j >= 0; --j) {
                if (dp.get(i).containsKey(nums[i] - nums[j])) {
                    continue;
                }
                int temp = dp.get(j).getOrDefault(nums[i] - nums[j], 1);
                result = Math.max(result, temp + 1);
                dp.get(i).put(nums[i] - nums[j], temp + 1);
            }
        }
        return result;
    }

}
