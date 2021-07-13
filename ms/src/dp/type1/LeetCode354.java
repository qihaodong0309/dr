package dp.type1;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author qihaodong
 */
public class LeetCode354 {

    public static void main(String[] args) {
        LeetCode354 test = new LeetCode354();
    }

    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] > o2[0] ? 1 : -1;
            }
        });
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);
        int result = 1;
        for (int i = 1; i < dp.length; ++i) {
            for (int j = i - 1; j >= 0; --j) {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                result = Math.max(result, dp[i]);
            }
        }
        return result;
    }

}
