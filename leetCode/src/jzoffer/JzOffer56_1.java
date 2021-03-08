package jzoffer;

/**
 * @author qihaodong
 */
public class JzOffer56_1 {

    /**
     * 异或思路
     *
     * @param nums
     * @return
     */
    public int[] singleNumbers(int[] nums) {
        int temp = 0, record = 1;
        for (int n : nums) {
            temp ^= n;
        }
        while ((record & temp) == 0) {
            record <<= 1;
        }
        int a = 0, b = 0;
        for (int n : nums) {
            if ((n & record) != 0) {
                a ^= n;
            } else {
                b ^= n;
            }
        }
        return new int[]{a, b};
    }

}
