package algorithm.dp;

/**
 * 同 JzOffer 63
 *
 * @author qihaodong
 */
public class LeetCode121 {

    /**
     * K神优化代码 (相同思路)
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE, result = 0;
        for (int i = 0; i < prices.length; i++) {
            buy = Math.min(buy, prices[i]);
            result = Math.max(result, prices[i] - buy);
        }
        return result;
    }

}
