package dp;

/**
 * @author qihaodong
 */
public class LeetCode877 {

    /**
     * 数学算法
     *
     * @param piles
     * @return
     */
    public boolean stoneGame(int[] piles) {
        return true;
    }

    /**
     * dp
     *
     * @param piles
     * @return
     */
    public boolean stoneGame2(int[] piles) {
        int length = piles.length;
        int[][] dp = new int[length + 1][length + 1];
        for (int i = 1; i <= length; i++) {
            dp[i][i] = piles[i - 1];
        }
        for (int i = length - 1; i >= 1; i--) {
            for (int j = i + 1; j <= length; j++) {
                dp[i][j] = Math.max(piles[i - 1] - dp[i + 1][j], piles[j - 1] - dp[i][j - 1]);
            }
        }
        return dp[1][length] > 0;
    }

    /**
     * 优化 dp
     *
     * @param piles
     * @return
     */
    public boolean stoneGame3(int[] piles) {
        int length = piles.length;
        int[][] dp = new int[2][length + 1];
        for (int i = length; i >= 1; i--) {
            for (int j = i; j <= length; j++) {
                int index = i % 2;
                int temp = index == 0 ? 1 : 0;
                if (i == j) {
                    dp[index][j] = piles[i - 1];
                } else {
                    dp[index][j] = Math.max(piles[i - 1] - dp[temp][j], piles[j - 1] - dp[index][j - 1]);
                }
            }
        }
        return dp[1][length] > 0;
    }

}