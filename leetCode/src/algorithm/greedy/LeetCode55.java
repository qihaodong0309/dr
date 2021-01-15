package algorithm.greedy;

/**
 * @author qihaodong
 */
public class LeetCode55 {

    /*
    对于该题来说，只要保证从初始位置能跳到末尾即可，举个例子：23114
    本题中最后一个点值不用考虑，无效数据
    下标3的数组值为1，可以跳到末尾，也就是说最多只要能跳到下标为3的位置，就能跳到末尾，问题也就转换为能否跳到下标3
    下标2的数值为1，可以跳到下标3，而上面分析跳到下标3就能跳到末尾，也就是说最多跳到下标2就可以跳到末尾
    继续向上分析，只要是初始位置能跳到的最小的坐标即可
     */

    /**
     * 贪心算法
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return true;
        }
        int record = n - 1, index = n - 2;
        while (index >= 0) {
            if (index + nums[index] >= record) {
                record = index;
            }
            index--;
        }
        return record == 0 ? true : false;
    }

}
