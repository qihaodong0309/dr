package dp.type6;

/**
 * @author qihaodong
 */
public class LeetCode583 {

    public static void main(String[] args) {
        LeetCode583 test = new LeetCode583();
        test.minDistance("sea", "eat");
    }

    public int minDistance(String word1, String word2) {
        if (word1 == null || word1.length() == 0) {
            return word2 == null ? 0 : word2.length();
        }
        if (word2 == null || word2.length() == 0) {
            return word1 == null ? 0 : word1.length();
        }
        int max = 0, l1 = word1.length(), l2 = word2.length();
        int[][] dp = new int[l1][l2];
        for (int i = 0; i < l1; ++i) {
            for (int j = 0; j < l2; ++j) {
                int temp = i > 0 && j > 0 ? dp[i - 1][j - 1] : 0;
                boolean judge = word1.charAt(i) == word2.charAt(j);
                dp[i][j] = temp + (judge ? 1 : 0);
                int judge1 = i > 0 ? dp[i - 1][j] : 0;
                int judge2 = j > 0 ? dp[i][j - 1] : 0;
                dp[i][j] = Math.max(dp[i][j], Math.max(judge1, judge2));
            }
        }
        return l1 + l2 - 2 * dp[l1 - 1][l2 - 1];
    }

}
