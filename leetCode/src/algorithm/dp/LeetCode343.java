package algorithm.dp;

/**
 * 同 LeetCode 14_1
 *
 * @author qihaodong
 */
public class LeetCode343 {

    /**
     * 基于dp的思想
     *
     * @param n
     * @return
     */
    public int integerBreak(int n) {
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

}
