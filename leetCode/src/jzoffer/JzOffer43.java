package jzoffer;

/**
 * 同 LeetCode233
 *
 * @author qihaodong
 */
public class JzOffer43 {

    /**
     * K神解法（算术法）
     *
     * @param n
     * @return
     */
    public int countDigitOne(int n) {
        int result = 0, record = 1, cur = n % 10, large = n / 10, low = 0;
        while (large != 0 || cur != 0) {
            if (cur == 0) {
                result += large * record;
            } else if (cur == 1) {
                result += large * record + low + 1;
            } else {
                result += (large + 1) * record;
            }
            low += cur * record;
            cur = large % 10;
            large /= 10;
            record *= 10;
        }
        return result;
    }

    /**
     * 递归解法
     *
     * @param n
     * @return
     */
    public int countDigitOne2(int n) {
        return echo(n);
    }

    private int echo(int n) {
        if (n == 0) {
            return n;
        }
        int temp = n, length = 1, top, other;
        while (temp >= 10) {
            temp /= 10;
            length *= 10;
        }
        top = temp;
        other = n - top * length;
        if (top == 1) {
            return echo(length - 1) + 1 + other + echo(other);
        } else {
            return temp * echo(length - 1) + length + echo(other);
        }
    }

}
