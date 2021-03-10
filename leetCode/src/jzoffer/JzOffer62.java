package jzoffer;

/**
 * 约瑟夫环问题
 *
 * @author qihaodong
 */
public class JzOffer62 {

    /**
     * K神思路 (dp)
     *
     * @param n
     * @param m
     * @return
     */
    public int lastRemaining(int n, int m) {
        int result = 0;
        for (int i = 2; i <= n; i++) {
            result = (result + m) % i;
        }
        return result;
    }

}
