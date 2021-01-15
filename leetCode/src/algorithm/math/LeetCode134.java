package algorithm.math;

/**
 * @author qihaodong
 */
public class LeetCode134 {

    /**
     * 一次遍历法
     *
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit1(int[] gas, int[] cost) {
        int i = 0, length = gas.length;
        while (i < length) {
            int sumGas = 0, sumCost = 0, temp = 0;
            while (temp < length) {
                int j = (i + temp) % length;
                sumGas += gas[j];
                sumCost += cost[j];
                if (sumCost > sumGas) {
                    break;
                }
                temp++;
            }
            if (temp == length) {
                return i;
            } else {
                i = i + temp + 1;
            }
        }
        return -1;
    }

    /**
     * 图解法
     *
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int length = gas.length, record = 0, min = Integer.MAX_VALUE, index = 0;
        for (int i = 0; i < length; i++) {
            record += gas[i] - cost[i];
            if (record < min) {
                min = record;
                index = i;
            }
        }
        return record < 0 ? -1 : (index + 1) % length;
    }

}
