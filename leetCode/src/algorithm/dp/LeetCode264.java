package algorithm.dp;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 同 JzOffer 49
 *
 * @author qihaodong
 */
public class LeetCode264 {

    /**
     * 采用堆
     *
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> heap = new PriorityQueue() {{
            add(1L);
        }};
        Set<Long> set = new HashSet() {{
            add(1L);
        }};
        int[] record = new int[]{2, 3, 5};
        int[] nums = new int[n];
        long curUgly, newUgly;
        for (int i = 0; i < n; i++) {
            curUgly = heap.poll();
            nums[i] = (int) curUgly;
            for (int j : record) {
                newUgly = curUgly * j;
                if (!set.contains(newUgly)) {
                    set.add(newUgly);
                    heap.add(newUgly);
                }
            }
        }
        return nums[n - 1];
    }

    /**
     * 动态规划
     *
     * @param n
     * @return
     */
    public int nthUglyNumber2(int n) {
        int a = 1, b = 1, c = 1;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int x1 = dp[a] * 2, x2 = dp[b] * 3, x3 = dp[c] * 5;
            dp[i] = Math.max(Math.max(x1, x2), x3);
            if (dp[i] == x1) {
                a++;
            }
            if (dp[i] == x2) {
                b++;
            }
            if (dp[i] == x3) {
                c++;
            }
        }
        return dp[n - 1];
    }

}
