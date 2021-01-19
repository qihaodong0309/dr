package algorithm.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qihaodong
 */
public class LeetCode22 {

    public static void main(String[] args) {
        LeetCode22 test = new LeetCode22();
        test.generateParenthesis(3);
    }

    /**
     * dfs
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(result, n, "", 0, 0);
        return result;
    }

    private void dfs(List<String> result, int n, String temp, int left, int right) {
        if (left + right == 2 * n) {
            result.add(temp);
            return;
        }
        if (left < n) {
            dfs(result, n, temp + '(', left + 1, right);
            if (left > right) {
                dfs(result, n, temp + ')', left, right + 1);
            }
        } else {
            dfs(result, n, temp + ')', left, right + 1);
        }
    }

}
