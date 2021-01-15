package algorithm.dp;

/**
 * @author qihaodong
 */
public class LeetCode1140 {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 100};
        new LeetCode1140().stoneGameII(a);
    }

    /**
     * dp
     *
     * @param piles
     * @return
     */
    public int stoneGameII(int[] piles) {
        int length = piles.length, echo = 0;
        int[][] dp = new int[length + 1][length];
        for (int i = length; i >= 1; i--) {
            echo += piles[i - 1];
            for (int j = 1; j < length; j++) {
                if (i + 2 * j > length) {
                    dp[i][j] = echo;
                } else {
                    for (int t = 1; t <= 2 * j; t++) {
                        dp[i][j] = Math.max(dp[i][j], echo - dp[i + t][Math.max(t, j)]);
                    }
                }
            }
        }
        return dp[1][1];
    }

}