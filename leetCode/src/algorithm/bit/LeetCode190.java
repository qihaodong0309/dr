package algorithm.bit;

/**
 * @author qihaodong
 */
public class LeetCode190 {

    public static void main(String[] args) {
        LeetCode190 test = new LeetCode190();
        System.out.println(test.reverseBits(123));
    }

    /**
     * 位运算法
     *
     * @param n
     * @return
     */
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32 && n != 0; ++i) {
            result |= (n & 1) << (31 - i);
            n >>>= 1;
        }
        return result;
    }



}
