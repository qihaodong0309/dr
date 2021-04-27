package algorithm.dichotomy;

/**
 * @author qihaodong
 */
public class LeetCode1011 {

    /**
     * 二分查找
     *
     * @param weights
     * @param D
     * @return
     */
    public int shipWithinDays(int[] weights, int D) {
        int left = 0, right = 0;
        for (int i = 0; i < weights.length; i++) {
            left = Math.max(left, weights[i]);
            right += weights[i];
        }
        while (left < right) {
            int mid = (left + right) / 2;
            int day = 1, temp = 0;
            for (int i : weights) {
                if (temp + i > mid) {
                    ++day;
                    temp = 0;
                }
                temp += i;
            }
            if (day <= D) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

}
