package jzoffer;

/**
 * 同 LeetCode 400
 *
 * @author qihaodong
 */
public class JzOffer44 {

    public static void main(String[] args) {
        JzOffer44 test = new JzOffer44();
        test.findNthDigit(1000000000);
    }

    /**
     * 数学计算法
     *
     * @param n
     * @return
     */
    public int findNthDigit(int n) {
        long num = 9, index = 1;
        while (n > num * index) {
            n -= num * index;
            num *= 10;
            index += 1;
        }
        long record = num / 9 + n / index, p = n % index;
        if (p == 0) {
            return (int) ((record - 1) % 10);
        } else {
            for (int i = 1; i <= (index - p); i++) {
                record = record / 10;
            }
            return (int) (record % 10);
        }
    }

}
