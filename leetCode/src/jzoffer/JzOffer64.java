package jzoffer;

/**
 * @author qihaodong
 */
public class JzOffer64 {

    /**
     * K神递归思路
     * 因为不能用 IF 判断，这里使用 boolean 制造短路
     *
     * @param n
     * @return
     */
    public int sumNums(int n) {
        boolean x = n > 1 && (n += sumNums(n - 1)) >= 0;
        return n;
    }

}
