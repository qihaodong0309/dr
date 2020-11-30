package math;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qihaodong
 */
public class LeetCode454 {

    /**
     * 循环遍历法（数据太多会超时）
     *
     * @param A
     * @param B
     * @param C
     * @param D
     * @return
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int result = 0, n = A.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    for (int t = 0; t < n; t++) {
                        if (A[i] + B[j] + C[k] + D[t] == 0) {
                            result++;
                        }
                    }
                }
            }
        }
        return result;
    }

    /**
     * 四层循环优化为两层循环（仍然会超时，过的测试用例更多了）
     *
     * @param A
     * @param B
     * @param C
     * @param D
     * @return
     */
    public int fourSumCount2(int[] A, int[] B, int[] C, int[] D) {
        int result = 0, n = A.length;
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int tempA = A[i] + B[j];
                int tempB = C[i] + D[j];
                if (map1.containsKey(tempA)) {
                    map1.put(tempA, map1.get(tempA) + 1);
                } else {
                    map1.put(tempA, 1);
                }
                if (map2.containsKey(tempB)) {
                    map2.put(tempB, map2.get(tempB) + 1);
                } else {
                    map2.put(tempB, 1);
                }
            }
        }
        for (int i : map1.keySet()) {
            for (int j : map2.keySet()) {
                if (i + j == 0) {
                    result += map1.get(i) * map2.get(j);
                }
            }
        }
        return result;
    }

    /**
     * 方法二再优化
     *
     * @param A
     * @param B
     * @param C
     * @param D
     * @return
     */
    public int fourSumCount3(int[] A, int[] B, int[] C, int[] D) {
        int result = 0, n = A.length;
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int tempA = A[i] + B[j];
                if (map1.containsKey(tempA)) {
                    map1.put(tempA, map1.get(tempA) + 1);
                } else {
                    map1.put(tempA, 1);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map1.containsKey(0 - C[i] - D[j])) {
                    result += map1.get(0 - C[i] - D[j]);
                }
            }
        }
        return result;
    }

}
