package jzoffer;

/**
 * 同 LeetCode 169
 *
 * @author qihaodong
 */
public class JzOffer39 {

    /**
     * 投票法
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int x = 0, times = 0;
        for (int n : nums) {
            if (times == 0) {
                x = n;
            }
            times += n == x ? 1 : -1;
        }
        return x;
    }

}

