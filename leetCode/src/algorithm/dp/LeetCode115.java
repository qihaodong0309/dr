package algorithm.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qihaodong
 */
public class LeetCode115 {

    public static void main(String[] args) {
        LeetCode115 test = new LeetCode115();
        System.out.println(test.numDistinct("rabbbit", "rabbit"));
    }

    /**
     * 递归（会超时）
     *
     * @param s
     * @param t
     * @return
     */
    public int numDistinct(String s, String t) {
        if (s.length() == t.length()) {
            return s.equals(t) ? 1 : 0;
        } else if (s.length() < t.length()) {
            return 0;
        }
        echo(s.toCharArray(), "", 0, t.length());
        int result = 0;
        for (String temp : strS) {
            result += temp.equals(t) ? 1 : 0;
        }
        return result;
    }

    List<String> strS = new ArrayList<>();

    private void echo(char[] chars, String temp, int start, int length) {
        if (temp.length() == length) {
            strS.add(temp);
            return;
        }
        for (int i = start; i < chars.length; i++) {
            temp = temp + chars[i];
            echo(chars, temp, i + 1, length);
            temp = temp.substring(0, temp.length() - 1);
        }
    }

    /**
     * 官方题解 (DP)
     *
     * @param s
     * @param t
     * @return
     */
    public int numDistinct2(String s, String t) {
        int m = s.length(), n = t.length();
        if (m < n) {
            return 0;
        }
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][n] = 1;
        }
        for (int i = m - 1; i >= 0; i--) {
            char sc = s.charAt(i);
            for (int j = n - 1; j >= 0; j--) {
                char tc = t.charAt(j);
                if (sc == tc) {
                    dp[i][j] = dp[i + 1][j + 1] + dp[i + 1][j];
                } else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }
        return dp[0][0];
    }

}
