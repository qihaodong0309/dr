package algorithm.bit;

/**
 * @author qihaodong
 */
public class LeetCode1734 {

    /**
     * 位运算
     *
     * @param encoded
     * @return
     */
    public int[] decode(int[] encoded) {
        int n = encoded.length + 1, total = 0, odd = 0;
        int[] result = new int[n];
        for (int i = 1; i <= n; i++) {
            total ^= i;
        }
        for (int i = 1; i < n - 1; i = i + 2) {
            odd ^= encoded[i];
        }
        result[0] = total ^ odd;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] ^ encoded[i - 1];
        }
        return result;
    }

}
