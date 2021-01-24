package jzoffer;

/**
 * @author qihaodong
 */
public class JzOffer14_2 {

    /**
     * 和 JzOffer14_1 相同，加上取模运算即可
     *
     * @param n
     * @return
     */
    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int b = n % 3, temp = 1000000007;
        long result = 1, a = 3;
        for (int i = n / 3 - 1; i > 0; i = i / 2) {
            if (i % 2 == 1) {
                result = (result * a) % temp;
            }
            a = (a * a) % temp;
        }
        if (b == 0) {
            return (int) ((result * 3) % temp);
        } else if (b == 1) {
            return (int) ((result * 4) % temp);
        } else {
            return (int) ((result * 6) % temp);
        }
    }

    /**
     * 上述乘法拆分
     *
     * @param n
     * @return
     */
    public int cuttingRope2(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int a = n / 3, b = n % 3, temp = 1000000007;
        long result = 1;
        for (int i = 1; i <= a - 1; i++) {
            result = (result * 3) % temp;
        }
        if (b == 0) {
            return (int) ((result * 3) % temp);
        } else if (b == 1) {
            return (int) ((result * 4) % temp);
        } else {
            return (int) ((result * 6) % temp);
        }
    }

}
