package algorithm.dp;

/**
 * @author qihaodong
 */
public class LeetCode122 {

    /**
     * 数学思维考虑
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int result = 0, left = prices[0], right = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] <= prices[i - 1]) {
                result += right - left;
                left = prices[i];
            }
            right = prices[i];
        }
        return result + right - left;
    }

    /**
     * 动态规划
     * dp[n][0] 表示第 n+1 天手上没有股票的最大利润
     * dp[n][1] 表示第 n+1 天手上有股票的最大利润
     *
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }

    /**
     * dp 空间优化
     *
     * @param prices
     * @return
     */
    public int maxProfit3(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length, result = 0, record = -prices[0];
        for (int i = 1; i < n; i++) {
            int temp1 = result, temp2 = record;
            result = Math.max(temp1, temp2 + prices[i]);
            record = Math.max(temp2, temp1 - prices[i]);
        }
        return result;
    }

    /**
     * 贪心算法，每天都交易
     *
     * @param prices
     * @return
     */
    public int maxProfit4(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length, result = 0;
        for (int i = 1; i < n; i++) {
            result += Math.max(0, prices[i] - prices[i - 1]);
        }
        return result;
    }

}
