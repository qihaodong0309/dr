package jzoffer;

/**
 * 同 LeetCode 121
 *
 * @author qihaodong
 */
public class JzOffer63 {

    /**
     * 直接遍历法
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE, result = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < buy) {
                buy = prices[i];
            } else if (prices[i] > buy) {
                result = Math.max(result, prices[i] - buy);
            }
        }
        return result;
    }

}
