package jzoffer;

/**
 * @author qihaodong
 */
public class JzOffer53_2 {

    /**
     * 简单遍历判断法
     *
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }

    /**
     * K神解法：二分法判断
     *
     * @param nums
     * @return
     */
    public int missingNumber2(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] == m) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return i;
    }

}
