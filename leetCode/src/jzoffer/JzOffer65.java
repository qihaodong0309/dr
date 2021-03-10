package jzoffer;

/**
 * @author qihaodong
 */
public class JzOffer65 {

    /*
    两个数相加实际上就等于它们的异或结果 + 与结果左移一位
     */

    /**
     * K神解法 (位运算)
     *
     * @param a
     * @param b
     * @return
     */
    public int add(int a, int b) {
        while (b != 0) {
            int c = (a & b) << 1;
            a = a ^ b;
            b = c;
        }
        return a;
    }

    /**
     * K神解法 (递归版，容易理解)
     *
     * @param a
     * @param b
     * @return
     */
    public int add2(int a, int b) {
        if (b == 0) {
            return a;
        }
        return add2(a ^ b, (a & b) << 1);
    }

}
