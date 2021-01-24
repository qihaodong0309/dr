package jzoffer;

/**
 * @author qihaodong
 */
public class JzOffer14_1 {

    /**
     * 基于dp的思想
     *
     * @param n
     * @return
     */
    public int cuttingRope(int n) {
        if (n == 0 || n == 1) {
            return 0;
        }
        int[] result = new int[n + 1];
        result[2] = 1;
        for (int i = 3; i <= n; i++) {
            result[i] = i - 1;
            for (int j = i - 2; j >= (i + 1) / 2; j--) {
                result[i] = Math.max(result[i], Math.max(j, result[j]) * Math.max((i - j), result[i - j]));
            }
        }
        return result[n];
    }

    /**
     * 数学推论，理论上切 3 最优，如果余1，将一个3和余数转化为 2*2，余2直接乘2
     *
     * @param n
     * @return
     */
    public int cuttingRope2(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int a = n / 3, b = n % 3;
        if (b == 0) {
            return (int) Math.pow(3, a);
        } else if (b == 1) {
            return (int) Math.pow(3, a - 1) * 4;
        } else {
            return (int) Math.pow(3, a) * 2;
        }
    }

}