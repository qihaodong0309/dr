package dp;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author qihaodong
 */
public class LeetCode131 {

    public static void main(String[] args) {
        new LeetCode131().partition("aab");
    }

    /**
     * 回溯法
     *
     * @param s
     * @return
     */
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        echo(result, new ArrayList<>(), s);
        return result;
    }

    private void echo(List<List<String>> result, List<String> temp, String s) {
        int n = s.length();
        if (n == 0) {
            List<String> stringList = new ArrayList<>();
            for (String ss : temp) {
                stringList.add(ss);
            }
            result.add(stringList);
            return;
        }
        for (int i = 1; i <= n; i++) {
            String left = s.substring(0, i);
            String right = s.substring(i, n);
            if (isEcho(left)) {
                temp.add(left);
                echo(result, temp, right);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private boolean isEcho(String s) {
        int n = s.length();
        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 回溯法
     *
     * @param s
     * @return
     */
    public List<List<String>> partition2(String s) {
        List<List<String>> result = new ArrayList<>();
        echo(s, 0, s.length(), new ArrayDeque<>(), result);
        return result;
    }

    private void echo(String s, int start, int end, Deque<String> deque, List<List<String>> result) {
        if (start == end) {
            result.add(new ArrayList<>(deque));
            return;
        }
        for (int i = start; i < end; i++) {
            if (!isEcho(s, start, i)) {
                continue;
            }
            deque.addLast(s.substring(start, i + 1));
            echo(s, i + 1, end, deque, result);
            deque.removeLast();
        }
    }

    private boolean isEcho(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    /**
     * dp + 回溯法
     *
     * @param s
     * @return
     */
    public List<List<String>> partition3(String s) {
        int n = s.length();
        if (n == 0) {
            return new ArrayList<>();
        }
        boolean[][] dp = new boolean[n][n];
        for (int right = 0; right < n; right++) {
            for (int left = 0; left <= right; left++) {
                if (s.charAt(left) == s.charAt(right) && (right - left <= 2 || dp[left + 1][right - 1])) {
                    dp[left][right] = true;
                }
            }
        }
        List<List<String>> result = new ArrayList<>();
        echo(s, 0, n, dp, new ArrayDeque<>(), result);
        return result;
    }

    private void echo(String s, int start, int end, boolean[][] dp, Deque<String> deque, List<List<String>> result) {
        if (start == end) {
            result.add(new ArrayList<>(deque));
            return;
        }
        for (int i = start; i < end; i++) {
            if (!dp[start][i]) {
                continue;
            }
            deque.addLast(s.substring(start, i + 1));
            echo(s, i + 1, end, dp, deque, result);
            deque.removeLast();
        }
    }

}
