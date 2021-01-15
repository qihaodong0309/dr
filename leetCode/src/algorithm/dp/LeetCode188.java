package algorithm.dp;

import java.util.Arrays;

/**
 * @author qihaodong
 */
public class LeetCode188 {

    /**
     * dp
     *
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit(int k, int[] prices) {
        if (k == 0 || prices == null || prices.length <= 1) {
            return 0;
        }
        int n = prices.length;
        // 数组长度为 n 时，最多交易 n / 2 次，取两者最大值
        k = Math.min(n / 2, k);
        // 表示前 n 天，共交易了 k + 1 次，并且手上还有股票
        int[][] dpBuy = new int[n][k + 1];
        // 表示前 n 天，共交易了 k + 1 次，此时手上没有股票
        int[][] dpSell = new int[n][k + 1];
        // 表示买了第一天的股票，此时总盈利0，因此该值为 -prices[0]
        dpBuy[0][0] = -prices[0];
        // 表示第一天啥都没干
        dpSell[0][0] = 0;
        for (int i = 1; i < k; i++) {
            // 第一天时，不可能完成买和卖两个操作，这里表示不可能
            dpBuy[0][i] = dpSell[0][i] = Integer.MIN_VALUE / 2;
        }
        for (int i = 1; i < n; i++) {
            // 到第 i + 1 天，没完成交易并手上有股票，最多的情况为当天买的或不是当天买的
            dpBuy[i][0] = Math.max(dpBuy[i - 1][0], dpSell[i - 1][0] - prices[i]);
            for (int j = 1; j <= k; j++) {
                dpBuy[i][j] = Math.max(dpBuy[i - 1][j], dpSell[i - 1][j] - prices[i]);
                dpSell[i][j] = Math.max(dpSell[i - 1][j], dpBuy[i - 1][j - 1] + prices[i]);
            }
        }
        return Arrays.stream(dpSell[n - 1]).max().getAsInt();
    }

    /**
     * dp优化
     *
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit2(int k, int[] prices) {
        if (k == 0 || prices == null || prices.length <= 1) {
            return 0;
        }
        int n = prices.length;
        k = Math.min(n / 2, k);
        int[] dpBuy = new int[k + 1];
        int[] dpSell = new int[k + 1];
        dpBuy[0] = -prices[0];
        dpSell[0] = 0;
        for (int i = 1; i < k; i++) {
            dpBuy[i] = dpSell[i] = Integer.MIN_VALUE / 2;
        }
        for (int i = 1; i < n; ++i) {
            dpBuy[0] = Math.max(dpBuy[0], dpSell[0] - prices[i]);
            for (int j = 1; j <= k; j++) {
                dpBuy[j] = Math.max(dpBuy[j], dpSell[j] - prices[i]);
                dpSell[j] = Math.max(dpSell[j], dpBuy[j - 1] + prices[i]);
            }
        }
        return Arrays.stream(dpSell).max().getAsInt();
    }

}
