package algorithm.bit;

/**
 * @author qihaodong
 */
public class LeetCode137 {

    /**
     * 依次计算二进制每一位
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < 32; ++i) {
            int total = 0;
            for (int num : nums) {
                total += (num >> i) & 1;
            }
            if (total % 3 != 0) {
                result = result | (1 << i);
            }
        }
        return result;
    }

}
