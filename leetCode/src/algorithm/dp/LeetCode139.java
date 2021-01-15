package algorithm.dp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author qihaodong
 */
public class LeetCode139 {

    /**
     * 经典回溯法会超时
     *
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        if (n == 0) {
            return false;
        }
        return echo(s, 0, n, wordDict);
    }

    private boolean echo(String s, int start, int end, List<String> wordDict) {
        if (start == end) {
            return true;
        }
        for (int i = start; i <= end; i++) {
            String temp = s.substring(start, i);
            if (judge(temp, wordDict) && echo(s, i, end, wordDict)) {
                return true;
            }
        }
        return false;
    }

    private boolean judge(String s, List<String> list) {
        for (String temp : list) {
            if (s.equals(temp)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 想办法优化（经典回溯 + dp） 仍然超时，因为缺少合并逻辑
     *
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak2(String s, List<String> wordDict) {
        int n = s.length();
        if (n == 0) {
            return false;
        }
        int[][] dp = new int[n + 1][n + 1];
        return echo(s, 0, n, dp, wordDict);
    }

    private boolean echo(String s, int start, int end, int[][] dp, List<String> wordDict) {
        if (start == end) {
            return true;
        }
        for (int i = start; i <= end; i++) {
            if (dp[start][i] == -1) {
                continue;
            } else {
                if (dp[start][i] == 0) {
                    String temp = s.substring(start, i);
                    dp[start][i] = judge(temp, wordDict) == true ? 1 : -1;
                }
                if (dp[start][i] == 1 && echo(s, i, end, dp, wordDict)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 更深层次dp
     *
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak3(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

}
