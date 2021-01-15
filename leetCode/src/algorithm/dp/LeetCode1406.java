package algorithm.dp;

/**
 * @author qihaodong
 */
public class LeetCode1406 {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, -9};
        System.out.println(new LeetCode1406().stoneGameIII2(a));
    }

    public String stoneGameIII(int[] stoneValue) {
        int length = stoneValue.length, temp = 0;
        int[] dp = new int[length + 2];
        for (int i = length; i >= 1; i--) {
            temp += stoneValue[i - 1];
            if (i == length) {
                dp[i] = stoneValue[i - 1];
            } else {
                dp[i] = Integer.MIN_VALUE;
                for (int j = 0; j < 3 && i + j <= length; j++) {
                    dp[i] = Math.max(dp[i], temp - dp[i + j + 1]);
                }
            }
        }
        int result = dp[1] * 2 - temp;
        if (result > 0) {
            return "Alice";
        } else if (result == 0) {
            return "Tie";
        } else {
            return "Bob";
        }
    }

    public String stoneGameIII2(int[] stoneValue) {
        int length = stoneValue.length;
        int[] dp = new int[length + 2];
        for (int i = length; i >= 1; i--) {
            int temp = 0;
            dp[i] = Integer.MIN_VALUE;
            for (int j = i; j <= length && j <= i + 2; j++) {
                temp = temp + stoneValue[j - 1];
                dp[i] = Math.max(dp[i], temp - dp[j + 1]);
            }
        }
        if (dp[1] == 0) {
            return "Tie";
        }
        return dp[1] > 0 ? "Alice" : "Bob";
    }

}
