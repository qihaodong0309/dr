package algorithm.math;

/**
 * 同 JzOffer 43
 *
 * @author qihaodong
 */
public class LeetCode223 {

    /**
     * k神方法
     *
     * @param n
     * @return
     */
    public int countDigitOne(int n) {
        int result = 0, record = 1, cur = n % 10, large = n / 10, low = 0;
        while (cur != 0 || large != 0) {
            if (cur == 0) {
                result += large * record;
            } else if (cur == 1) {
                result += large * record + 1 + low;
            } else {
                result += (large + 1) * record;
            }
            low += cur * record;
            cur = large % 10;
            large /= 10;
            record *= 10;
        }
        return result;
    }

}
