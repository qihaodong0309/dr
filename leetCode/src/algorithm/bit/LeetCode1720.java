package algorithm.bit;

/**
 * @author qihaodong
 */
public class LeetCode1720 {

    /**
     * 遍历法
     *
     * @param encoded
     * @param first
     * @return
     */
    public int[] decode(int[] encoded, int first) {
        int n = encoded.length;
        int[] result = new int[n + 1];
        result[0] = first;
        for (int i = 1; i <= n; i++) {
            result[i] = result[i - 1] ^ encoded[i - 1];
        }
        return result;
    }

}
