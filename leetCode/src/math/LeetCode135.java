package math;

import java.util.Arrays;

/**
 * @author qihaodong
 */
public class LeetCode135 {

    /*
    数学方法，找规律
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

}
