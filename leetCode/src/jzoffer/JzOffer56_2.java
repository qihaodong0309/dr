package jzoffer;

/**
 * @author qihaodong
 */
public class JzOffer56_2 {

    /**
     * k 神解法
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for (int n : nums) {
            ones = ones ^ n & ~twos;
            twos = twos ^ n & ~ones;
        }
        return ones;
    }

    /**
     * K 神解法：上述方法一优化
     *
     * @param nums
     * @return
     */
    public int singleNumber2(int[] nums) {
        int res = 0, m = 3;
        int[] counts = new int[32];
        for (int n : nums) {
            for (int j = 0; j < 32; j++) {
                counts[j] += n & 1;
                n >>>= 1;
            }
        }
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res |= counts[31 - i] % m;
        }
        return res;
    }

}
