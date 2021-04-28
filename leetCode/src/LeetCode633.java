/**
 * @author qihaodong
 */
public class LeetCode633 {

    /**
     * 暴力解法
     *
     * @param c
     * @return
     */
    public boolean judgeSquareSum(int c) {
        for (int i = 0; i <= getSqrt(c); i++) {
            int temp = c - i * i;
            if (judge(temp)) {
                return true;
            }
        }
        return false;
    }

    private int getSqrt(int x) {
        double result = Math.sqrt(x * 1.0);
        return (int) result;
    }

    private boolean judge(int x) {
        int result = getSqrt(x);
        return result * result == x;
    }

    /**
     * 双指针
     *
     * @param c
     * @return
     */
    public boolean judgeSquareSum2(int c) {
        int left = 0, right = (int) Math.sqrt(c);
        while (left <= right) {
            int sum = left * left + right * right;
            if (sum == c) {
                return true;
            } else if (sum > c) {
                right--;
            } else {
                left++;
            }
        }
        return false;
    }

}
