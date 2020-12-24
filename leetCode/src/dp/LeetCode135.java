package dp;

import java.util.Arrays;

/**
 * @author qihaodong
 */
public class LeetCode135 {

    /**
     * 数学方法，找规律，两次遍历
     *
     * @param ratings
     * @return
     */
    public int candy(int[] ratings) {
        int n = ratings.length, result = 0;
        if (n <= 1) {
            return n;
        }
        int[] record = new int[n];
        Arrays.fill(record, 1);
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                record[i] = record[i - 1] + 1;
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && record[i] <= record[i + 1]) {
                record[i] = record[i + 1] + 1;
            }
        }
        for (int i = 0; i < n; i++) {
            result += record[i];
        }
        return result;
    }

    /**
     * 一次遍历
     *
     * @param ratings
     * @return
     */
    public int candy2(int[] ratings) {
        int result = 1, n = ratings.length;
        int record = 1, current = 1, index = 0;
        for (int i = 1; i < n; i++) {
            if (ratings[i] >= ratings[i - 1]) {
                current = ratings[i] == ratings[i - 1] ? 1 : current + 1;
                result += current;
                record = current;
                index = 0;
            } else {
                index++;
                if (index == record) {
                    index++;
                }
                result += index;
                current = 1;
            }
        }
        return result;
    }

}
