package algorithm.bit;

/**
 * @author qihaodong
 */
public class LeetCode1486 {

    /**
     * 正常解法
     *
     * @param n
     * @param start
     * @return
     */
    public int xorOperation(int n, int start) {
        int result = 0;
        for (int i = 0; i < n; i++) {
            result ^= (start + 2 * i);
        }
        return result;
    }

}
