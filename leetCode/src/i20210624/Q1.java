package i20210624;

/**
 * @author qihaodong
 */
public class Q1 {

    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        a1(result);
        return result;
    }

    /**
     * 暴力解法
     */
    private void a1(int[] result) {
        for (int i = 0; i < result.length; i++) {
            int count = 0, temp = i;
            while (temp != 0) {
                count += temp % 2;
                temp = temp / 2;
            }
            result[i] = count;
        }
    }

}
