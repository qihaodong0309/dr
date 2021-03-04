package algorithm.math;

/**
 * 同 JzOffer 44
 *
 * @author qihaodong
 */
public class LeetCode400 {

    /**
     * 根据 k神 思路优化 JzOffer 代码
     *
     * @param n
     * @return
     */
    public int findNthDigit(int n) {
        long judge = 9, count = 1;
        while (n > judge * count) {
            n -= judge * count;
            judge *= 10;
            count += 1;
        }
        long num = (judge / 9) + (n - 1) / count;
        return Long.toString(num).charAt((n - 1) % (int) count) - '0';
    }

}
