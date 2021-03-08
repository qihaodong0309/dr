package algorithm.bit;

/**
 * 同 JzOffer 16
 *
 * @author qihaodong
 */
public class LeetCode50 {

    /*
    箭头指向的方向为移动的方向，> 表示右移，一般用2个
    >>> 表示无符号右移，一般针对负数，正数的 >> 和 >>> 效果是相同的
    < 表示左移，一般用2个
     */

    /**
     * 这里重写 JzOffer 16 方法二
     * 其实本题可以不用位运算，这里只是为了加深位运算理解
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        double result = 1, temp = x;
        long record = n < 0 ? -(long) n : n;
        while (record > 0) {
            if ((record & 1) == 1) {
                result *= temp;
            }
            temp *= temp;
            record >>= 1;
        }
        return n > 0 ? result : 1 / result;
    }

}
