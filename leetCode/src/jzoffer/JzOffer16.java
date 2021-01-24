package jzoffer;

/**
 * @author qihaodong
 */
public class JzOffer16 {

    /**
     * 直接遍历法，超时
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        double result = 1;
        for (int i = 1; i <= Math.abs(n); i++) {
            result *= x;
        }
        return n > 0 ? result : 1 / result;
    }

    /*
    Java 代码中 int32 变量 n \in [-2147483648, 2147483647] n∈[−2147483648,2147483647]
    所有有时候直接用 int 强转会报错，这里建议用 long 类型来保存
     */

    /**
     * 采用JzOffer 14_2 那种递归乘法
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow2(double x, int n) {
        double result = 1, temp = x;
        long record = n < 0 ? -1L * (long) n : n;
        for (long i = record; i > 0; i = i / 2) {
            if (i % 2 == 1) {
                result *= temp;
            }
            temp *= temp;
        }
        return n > 0 ? result : 1 / result;
    }

}
