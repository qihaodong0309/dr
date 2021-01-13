package math;

/**
 * @author qihaodong
 */
public class LeetCode371 {

    /**
     * 位运算
     *
     * @param a
     * @param b
     * @return
     */
    public int getSum(int a, int b) {
        while (b != 0) {
            // 异或计算
            int temp = a ^ b;
            // 计算进位
            b = (a & b) << 1;
            a = temp;
        }
        return a;
    }

}
