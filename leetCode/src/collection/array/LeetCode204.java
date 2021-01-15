package collection.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author qihaodong
 */
public class LeetCode204 {

    public static void main(String[] args) {
        new LeetCode204().countPrimes3(15);
    }

    public int countPrimes(int n) {
        int result = 0;
        for (int i = 2; i < n; i++) {
            if (judge(i)) {
                result++;
            }
        }
        return result;
    }

    private boolean judge(int n) {
        boolean result = true;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                result = false;
                break;
            }
        }
        return result;
    }

    /**
     * 数组记录法
     *
     * @param n
     * @return
     */
    public int countPrimes2(int n) {
        int result = 0;
        int[] record = new int[n];
        Arrays.fill(record, 1);
        for (int i = 2; i < n; i++) {
            if (record[i] == 1) {
                result += 1;
                int temp = 2 * i;
                while (temp < n) {
                    record[temp] = 0;
                    temp = temp + i;
                }
            }
        }
        return result;
    }

    /**
     * 方法二优化，减少记录次数
     *
     * @param n
     * @return
     */
    public int countPrimes3(int n) {
        List<Integer> list = new ArrayList<>();
        int[] record = new int[n];
        Arrays.fill(record, 1);
        for (int i = 2; i < n; i++) {
            if (record[i] == 1) {
                list.add(i);
            }
            for (int j = 0; j < list.size() && i * list.get(j) < n; j++) {
                record[i * list.get(j)] = 0;
                if (i % list.get(j) == 0) {
                    break;
                }
            }
        }
        return list.size();
    }

}
