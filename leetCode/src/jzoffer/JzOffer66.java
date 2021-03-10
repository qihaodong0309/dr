package jzoffer;

/**
 * @author qihaodong
 */
public class JzOffer66 {

    /**
     * dp
     *
     * @param a
     * @return
     */
    public int[] constructArr(int[] a) {
        if (a == null || a.length == 0) {
            return new int[0];
        }
        int[] dpL = new int[a.length];
        dpL[0] = 1;
        for (int i = 1; i < a.length; i++) {
            dpL[i] = dpL[i - 1] * a[i - 1];
        }
        int[] dpR = new int[a.length];
        dpR[a.length - 1] = 1;
        for (int i = a.length - 2; i >= 0; i--) {
            dpR[i] = dpR[i + 1] * a[i + 1];
        }
        int[] result = new int[a.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = dpR[i] * dpL[i];
        }
        return result;
    }

    /**
     * dp 空间优化
     *
     * @param a
     * @return
     */
    public int[] constructArr2(int[] a) {
        if (a == null || a.length == 0) {
            return new int[0];
        }
        int n = a.length, temp = 1;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = i > 0 ? result[i - 1] * a[i - 1] : 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            temp *= a[i + 1];
            result[i] *= temp;
        }
        return result;
    }

}
