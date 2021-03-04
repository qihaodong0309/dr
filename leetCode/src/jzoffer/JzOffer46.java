package jzoffer;

/**
 * @author qihaodong
 */
public class JzOffer46 {

    public static void main(String[] args) {
        JzOffer46 test = new JzOffer46();
        System.out.println(test.translateNum(12258));
    }

    /**
     * 递归
     *
     * @param num
     * @return
     */
    public int translateNum(int num) {
        if (num < 10) {
            return 1;
        } else if (num < 100) {
            if (num <= 25) {
                return 2;
            } else {
                return 1;
            }
        }
        String s = String.valueOf(num);
        int n = Integer.valueOf(s.substring(0, 2));
        if (n < 10) {
            return translateNum(Integer.valueOf(s.substring(1)));
        } else if (n <= 25) {
            return translateNum(Integer.valueOf(s.substring(1))) + translateNum(Integer.valueOf(s.substring(2)));
        } else {
            return translateNum(Integer.valueOf(s.substring(1)));
        }
    }

    /**
     * 上述递归方法优化
     *
     * @param num
     * @return
     */
    public int translateNum2(int num) {
        if (num < 10) {
            return 1;
        }
        if (num % 100 < 26 && num % 100 > 9) {
            return translateNum2(num / 100) + translateNum2(num / 10);
        } else {
            return translateNum2(num / 10);
        }
    }

}
