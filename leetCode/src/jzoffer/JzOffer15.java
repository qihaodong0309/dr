package jzoffer;

/**
 * @author qihaodong
 */
public class JzOffer15 {

    /**
     * 位运算法，每次与操作可以消除最右边的 0
     *
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int result = 0;
        while (n != 0) {
            n = n & n - 1;
            result++;
        }
        return result;
    }

    /**
     * 每次判断最低位，运算完后向右移动一位
     *
     * @param n
     * @return
     */
    public int hammingWeight2(int n) {
        int result = 0, temp = 1;
        while (n != 0) {
            result += n & 1;
            n = n >>> 1;
        }
        return result;
    }

}
