package dp.type4;

import java.util.HashMap;
import java.util.Map;

/**
 * 斐波那契、等差相关
 *
 * @author qihaodong
 */
public class LeetCode873 {

    public static void main(String[] args) {
        LeetCode873 test = new LeetCode873();
        System.out.println(test.lenLongestFibSubseq(new int[]{1, 2, 3, 4, 5, 6, 7, 8}));
    }

    /**
     * 穷举遍历法
     *
     * @param arr
     * @return
     */
    public int lenLongestFibSubseq(int[] arr) {
        int result = 2, n = arr.length;
        int pre, next, temp, num, index;
        for (int i = 0; i < n - 2; ++i) {
            for (int j = i + 1; j < n - 1; ++j) {
                pre = arr[i];
                next = arr[j];
                temp = pre + next;
                num = 2;
                index = j + 1;
                while (index < n && arr[index] <= temp) {
                    if (arr[index] == temp) {
                        pre = next;
                        next = temp;
                        temp = pre + next;
                        num++;
                    }
                    index++;
                }
                result = Math.max(result, num);
            }
        }
        return result == 2 ? 0 : result;
    }

    /**
     * 尝试用 dp 解决
     *
     * @param arr
     * @return
     */
    public int lenLongestFibSubseq2(int[] arr) {
        int result = 0, n = arr.length, temp;
        Map<Integer, Integer> indexM = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            indexM.put(arr[i], i);
        }
        Map<Integer, Integer> dp = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                int index = indexM.getOrDefault(arr[i] - arr[j], -1);
                if (index >= 0 && index < j) {
                    temp = dp.getOrDefault(index * n + j, 2) + 1;
                    dp.put(j * n + i, temp);
                    result = Math.max(result, temp);
                }
            }
        }
        return result > 2 ? result : 0;
    }

}
