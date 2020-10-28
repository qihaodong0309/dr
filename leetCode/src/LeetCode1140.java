/**
 * @author qihaodong
 */
public class LeetCode1140 {

    public static void main(String[] args) {
        LeetCode1140 s = new LeetCode1140();
        int[] a = {1, 2, 3, 4, 5, 100};
        s.stoneGameII(a);
    }

    /**
     * dp
     *
     * @param piles
     * @return
     */
    public int stoneGameII(int[] piles) {
        int length = piles.length, temp = 0;
        int[][] dp = new int[length + 1][length];
        for (int i = length; i >= 1; i--) {
            temp += piles[i - 1];
            for (int j = 1; j < length; j++) {
                if (i + j * 2 >= length) {
                    dp[i][j] = temp;
                } else {
                    for (int z = 1; z <= j * 2; z++) {
                        dp[i][j] = Math.max(dp[i][j], temp - dp[i + z][Math.max(j, z)]);
                    }
                }
            }
        }
        return dp[1][1];
    }

}