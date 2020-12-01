package greedy;

import java.util.Arrays;

/**
 * @author qihaodong
 */
public class LeetCode45 {

    public static void main(String[] args) {
        new LeetCode45().jump2(new int[]{2, 3, 1, 1, 4});
    }

    /*
    上一个同类型题目是计算能否跳到，这里求跳的最小次数。
    因此我们让节点跳到当前节点最远的能够到达终点的位置，这里我们通过数组记录每个节点需要几步到达终点
    本质上题目转换为dp
     */

    /**
     * dp 能通过，但是超出时间限制，此时我们考虑贪心算法
     *
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int[] record = new int[nums.length];
        Arrays.fill(record, 0);
        for (int i = nums.length - 2; i >= 0; i--) {
            int max = i + nums[i];
            while (max > i) {
                if (max >= nums.length - 1) {
                    record[i] = 1;
                    break;
                }
                if (record[max] > 0) {
                    record[i] = record[i] == 0 ? record[max] + 1 : Math.min(record[i], record[max] + 1);
                }
                max--;
            }
        }
        return record[0];
    }

    /**
     * 贪心，此时数组不再记录每个下标需要跳的次数，而是跳下标次数的最左侧下标
     *
     * @param nums
     * @return
     */
    public int jump2(int[] nums) {
        int[] record = new int[nums.length + 1];
        int result = 0, index = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] == 0) {
                continue;
            }
            int temp = i + nums[i];
            if (temp >= nums.length - 1) {
                record[1] = i;
                index = 1;
            } else {
                index = 1;
                while (index < record.length && temp < record[index]) {
                    index++;
                }
                index = index + 1;
                record[index] = i;
            }
            if (i == 0) {
                result = index;
            }
        }
        return result;
    }

    /**
     * 两层循环，index 表示下标，result 表示步数
     * 第 i 次外层循环计算 i 步走到末尾的最左边下标
     * 当最左边下标为 0 时，也就是从初始点出发的情况
     *
     * @param nums
     * @return
     */
    public int jump3(int[] nums) {
        int index = nums.length - 1, result = 0;
        while (index > 0) {
            for (int i = 0; i < index; i++) {
                if (i + nums[i] >= index) {
                    index = i;
                    result += 1;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * 从前往后贪心，分别记录第 n 步所能跳到的边界，假设第 n - 1 步能跳到的边界为 X ,第 n 步能跳到的边界为 y
     * 那么 x ~ y 之间的任何一个点都可以通过 n - 1 步跳到
     *
     * @param nums
     * @return
     */
    public int jump4(int[] nums) {
        int n = nums.length, result = 0, max = 0, end = 0;
        for (int i = 0; i < n - 1; i++) {
            max = Math.max(max, i + nums[i]);
            if (end == i) {
                end = max;
                result++;
            }
        }
        return result;
    }

}
