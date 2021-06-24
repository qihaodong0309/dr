package i20210624;

/**
 * @author qihaodong
 */
public class Q2 {

    public static void main(String[] args) {
        Q2 test = new Q2();
        test.isPowerOfFour2(177146);
    }

    /**
     * 暴力解法，超时
     *
     * @param n
     * @return
     */
    public boolean isPowerOfFour(int n) {
        if (n < 1) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        int start = 4;
        while (n > start) {
            start *= 4;
        }
        return n == start;
    }

    /**
     * 暴力解法优化
     *
     * @param n
     * @return
     */
    public boolean isPowerOfFour2(int n) {
        if (n < 1) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        long start = 4;
        while (n > start) {
            if (n > start * start) {
                start = start * start;
            } else {
                start *= 4;
            }
        }
        return n == start;
    }

}
