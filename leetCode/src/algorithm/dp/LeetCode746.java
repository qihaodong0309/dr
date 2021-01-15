package algorithm.dp;

/**
 * @author qihaodong
 */
public class LeetCode746 {

    public static void main(String[] args) {
        new LeetCode746().minCostClimbingStairs(new int[]{0, 0, 1, 0});
    }

    /**
     * dp
     *
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length, start = 2;
        if (n <= 1) {
            return 0;
        }
        int left = cost[0], right = cost[1];
        while (start < n) {
            int k = left;
            left = right;
            right = Math.min(k, right) + cost[start++];
        }
        return Math.min(left, right);
    }

}
