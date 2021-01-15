package algorithm.dp;

/**
 * @author qihaodong
 */
public class LeetCode97 {

    /**
     * 递归思路
     *
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        int length1 = s1.length(), length2 = s2.length(), length3 = s3.length();
        if (length1 + length2 != length3) {
            return false;
        }
        return echo(s1, s2, s3);
    }

    private boolean echo(String s1, String s2, String s3) {
        if (s1.length() == 0) {
            return s2.equals(s3);
        }
        if (s2.length() == 0) {
            return s1.equals(s3);
        }
        if (s1.charAt(0) == s3.charAt(0) && echo(s1.substring(1), s2, s3.substring(1))) {
            return true;
        }
        if (s2.charAt(0) == s3.charAt(0) && echo(s1, s2.substring(1), s3.substring(1))) {
            return true;
        }
        return false;
    }

    public boolean isInterleave2(String s1, String s2, String s3) {
        int length1 = s1.length(), length2 = s2.length(), length3 = s3.length();
        if (length1 + length2 != length3) {
            return false;
        }
        boolean[][] dp = new boolean[length1 + 1][length2 + 1];
        dp[0][0] = true;
        for (int i = 1; i <= length1; i++) {
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }
        for (int i = 1; i <= length2; i++) {
            dp[0][i] = dp[0][i - 1] && s2.charAt(i - 1) == s3.charAt(i - 1);
        }
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) ||
                        (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }
        return dp[length1][length2];
    }

    public boolean isInterleave3(String s1, String s2, String s3) {
        int length1 = s1.length(), length2 = s2.length(), length3 = s3.length();
        if (length1 + length2 != length3) {
            return false;
        }
        boolean[][] dp = new boolean[length1 + 1][length2 + 1];
        dp[0][0] = true;
        for (int i = 0; i <= length1; i++) {
            for (int j = 0; j <= length2; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                dp[i][j] = (i > 0 && dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) ||
                        (j > 0 && dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }
        return dp[length1][length2];
    }

}
