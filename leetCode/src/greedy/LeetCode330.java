package greedy;

/**
 * @author qihaodong
 */
public class LeetCode330 {

    /**
     * 贪心算法
     *
     * @param nums
     * @param n
     * @return
     */
    public int minPatches(int[] nums, int n) {
        int result = 0, index = 0, length = nums.length;
        long record = 1;
        while (record <= n) {
            if (index < length && nums[index] <= record) {
                record += nums[index];
                index++;
            } else {
                record *= 2;
                result++;
            }
        }
        return result;
    }

}
