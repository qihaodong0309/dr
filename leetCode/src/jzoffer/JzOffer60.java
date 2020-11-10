package jzoffer;

/**
 * @author qihaodong
 */
public class JzOffer60 {

    public static void main(String[] args) {
        new JzOffer60().dicesProbability3(3);
    }

    /**
     * 递归未超时
     *
     * @param n
     * @return
     */
    public double[] dicesProbability(int n) {
        int length = 5 * n + 1, num = (int) Math.pow(6, n);
        double[] result = new double[length];
        for (int i = n; i <= 6 * n; i++) {
            result[i - n] = (getCount(n, i) * 1.0) / num;
        }
        return result;
    }

    private int getCount(int num, int val) {
        if (num == 1) {
            return 1;
        }
        int result = 0,
                start = num - 1 >= val - 6 ? num - 1 : val - 6,
                end = 6 * (num - 1) <= val - 1 ? 6 * (num - 1) : val - 1;
        for (int i = start; i <= end; i++) {
            result += getCount(num - 1, i);
        }
        return result;
    }

    int[][] record = null;

    /**
     * 递归改dp
     *
     * @param n
     * @return
     */
    public double[] dicesProbability2(int n) {
        int length = 5 * n + 1, num = (int) Math.pow(6, n);
        double[] result = new double[length];
        record = new int[n + 1][6 * n + 1];
        for (int i = n; i <= 6 * n; i++) {
            result[i - n] = (getCount2(n, i) * 1.0) / num;
        }
        return result;
    }

    private int getCount2(int num, int val) {
        if (num == 1) {
            return 1;
        }
        if (record[num][val] != 0) {
            return record[num][val];
        }
        int result = 0,
                start = num - 1 >= val - 6 ? num - 1 : val - 6,
                end = 6 * (num - 1) <= val - 1 ? 6 * (num - 1) : val - 1;
        for (int i = start; i <= end; i++) {
            result += getCount(num - 1, i);
        }
        record[num][val] = result;
        return result;
    }

    /**
     * 纯dp
     *
     * @param n
     * @return
     */
    public double[] dicesProbability3(int n) {
        int length = 5 * n + 1, num = (int) Math.pow(6, n);
        double[] result = new double[length];
        int[][] record = new int[2][6 * n + 1];
        for (int i = 1; i <= 6; i++) {
            record[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            int index = i % 2;
            int temp = index == 0 ? 1 : 0;
            for (int j = i; j <= 6 * i; j++) {
                int z = 1;
                record[index][j] = 0;
                while (z <= j + 1 - i && z <= 6) {
                    record[index][j] += record[temp][j - z];
                    z++;
                }
            }
        }
        for (int i = n; i <= 6 * n; i++) {
            result[i - n] = (record[n % 2][i] * 1.0) / num;
        }
        return result;
    }

}
