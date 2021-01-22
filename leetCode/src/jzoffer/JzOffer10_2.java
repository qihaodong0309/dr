package jzoffer;

/**
 * @author qihaodong
 */
public class JzOffer10_2 {

    public int numWays(int n) {
        int a = 1, b = 1, temp;
        for (int i = 1; i <= n; i++) {
            temp = (a + b) % 1000000007;
            a = b;
            b = temp;
        }
        return a;
    }

}
