package algorithm.math;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author qihaodong
 */
public class LeetCode89 {

    /**
     * 遍历加回溯法，结果超时
     *
     * @param n
     * @return
     */
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add((int) Math.pow(2, i));
        }
        int length = (int) Math.pow(2, n);
        int[] record = new int[length];
        record[0] = 1;
        result.add(0);
        dfs(result, length, record, set);
        return result;
    }

    private boolean dfs(List<Integer> result, int length, int[] record, Set<Integer> set) {
        if (result.size() == length) {
            return true;
        }
        int num = result.get(result.size() - 1);
        for (int i = 0; i < record.length; i++) {
            if (record[i] == 0 && set.contains(num ^ i)) {
                record[i] = 1;
                result.add(i);
                if (dfs(result, length, record, set)) {
                    return true;
                }
                record[i] = 0;
                result.remove(result.size() - 1);
            }
        }
        return false;
    }

    /**
     * 数学运算法
     *
     * @param n
     * @return
     */
    public List<Integer> grayCode2(int n) {
        List<Integer> result = new ArrayList();
        result.add(0);
        int start = 1;
        for (int i = 0; i < n; i++) {
            for (int j = result.size() - 1; j >= 0; j--) {
                result.add(start + result.get(j));
            }
            start = start << 1;
        }
        return result;
    }

}
