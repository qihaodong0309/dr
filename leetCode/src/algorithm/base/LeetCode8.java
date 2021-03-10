package algorithm.base;

/**
 * 同 JzOffer67
 *
 * @author qihaodong
 */
public class LeetCode8 {

    /**
     * K神优化解法
     *
     * @param s
     * @return
     */
    public int myAtoi(String s) {
        int res = 0, max = Integer.MAX_VALUE / 10;
        int i = 0, sign = 1, length = s.length();
        if (length == 0) {
            return 0;
        }
        while (s.charAt(i) == ' ') {
            if (++i == length) {
                return 0;
            }
        }
        if (s.charAt(i) == '-') {
            sign = -1;
        }
        if (s.charAt(i) == '-' || s.charAt(i) == '+') {
            i++;
        }
        for (int j = i; j < length; j++) {
            if (s.charAt(j) < '0' || s.charAt(j) > '9') {
                break;
            }
            if (res > max || res == max && s.charAt(j) > '7') {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + (s.charAt(j) - '0');
        }
        return sign * res;
    }

}
