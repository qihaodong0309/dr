package algorithm.bit;

/**
 * @author qihaodong
 */
public class LeetCode136 {

    /*
    异或具有以下性质，任何数和自己异或都是0，任何数和0异或都是它本身，并且异或满足交换律和结合律
    & : 与：两个数必须都是1
    ~ ：非：非针对单个数字，如果这一位是0，变为1，否则变成0
    | : 或：两个数只要有一个数字为1就可以
    ^ ：异或：两个数不相等为1，相等为0
     */

    /**
     * 异或
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i : nums) {
            result = result ^ i;
        }
        return result;
    }

}
