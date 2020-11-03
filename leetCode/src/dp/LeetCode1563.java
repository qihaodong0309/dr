package dp;

/**
 * @author qihaodong
 */
public class LeetCode1563 {

    public static void main(String[] args) {
        int[] a = {6, 2, 3, 4, 5, 5};
        System.out.println(new LeetCode1563().stoneGameV(a));
    }

    /**
     * dp
     *
     * @param stoneValue
     * @return
     */
    public int stoneGameV(int[] stoneValue) {
        int length = stoneValue.length;
        int[][] record = new int[length + 1][length + 1];
        for (int i = 0; i <= length - 1; i++) {
            for (int j = 1; i + j <= length; j++) {
                int left = j, right = j + i;
                if (i == 0) {
                    record[j][j] = stoneValue[j - 1];
                } else {
                    record[left][right] = record[left][right - 1] + stoneValue[right - 1];
                }
            }
        }
        int[][] dp = new int[length + 1][length + 1];
        for (int i = 1; i <= length - 1; i++) {
            for (int j = 1; i + j <= length; j++) {
                int left = j, right = j + i;
                for (int z = left + 1; z <= right; z++) {
                    int temp = 0;
                    if (record[left][z - 1] == record[z][right]) {
                        temp = record[left][z - 1] + Math.max(dp[left][z - 1], dp[z][right]);
                    } else {
                        boolean judge = record[left][z - 1] < record[z][right];
                        temp = judge ? record[left][z - 1] + dp[left][z - 1] : record[z][right] + dp[z][right];
                    }
                    dp[left][right] = Math.max(dp[left][right], temp);
                }
            }
        }
        return dp[1][length];
    }

    int[][] record = null;

    /**
     * 优化代码后的dp
     *
     * @param stoneValue
     * @return
     */
    public int stoneGameV2(int[] stoneValue) {
        int n = stoneValue.length;
        record = new int[n + 1][n + 1];
        return dfs(stoneValue, 1, n);
    }

    private int dfs(int[] stoneValue, int left, int right) {
        if (left == right) {
            return 0;
        }
        if (record[left][right] != 0) {
            return record[left][right];
        }
        int sum = 0;
        for (int i = left; i <= right; i++) {
            sum += stoneValue[i - 1];
        }
        int leftVal = 0;
        for (int i = left; i < right; i++) {
            leftVal += stoneValue[i - 1];
            int rightVal = sum - leftVal;
            if (leftVal > rightVal) {
                record[left][right] = Math.max(record[left][right], rightVal + dfs(stoneValue, i + 1, right));
            } else if (leftVal == rightVal) {
                record[left][right] = Math.max(record[left][right],
                        leftVal + Math.max(dfs(stoneValue, left, i), dfs(stoneValue, i + 1, right)));
            } else {
                record[left][right] = Math.max(record[left][right], leftVal + dfs(stoneValue, left, i));
            }
        }
        return record[left][right];
    }

}
