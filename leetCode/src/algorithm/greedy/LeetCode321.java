package algorithm.greedy;

import java.util.Stack;

/**
 * @author qihaodong
 */
public class LeetCode321 {

    public static void main(String[] args) {
        int[] nums = new LeetCode321().maxNumber(new int[]{8, 5, 9, 5, 1, 6, 9}, new int[]{2, 6, 4, 3, 8, 4, 1, 0, 7, 2, 9, 2, 8}, 20);
        for (int x : nums) {
            System.out.println(x);
        }
    }

    /*
    循环遍历所有情况，从nums1取0个，从nums2取k-0个，一直到从num1从k个，从nums2取0个
    每次取最大值，去完之后交叉合并
     */

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] result = new int[k];
        int count = 0, num1 = nums1.length, num2 = nums2.length;
        while (count <= k) {
            if (count <= num1 && (k - count) <= num2) {
                int[] newNum1 = getMaxVal(nums1, count);
                int[] newNum2 = getMaxVal(nums2, k - count);
                int[] temp = mergeArray(newNum1, newNum2);
                if (judge(temp, result)) {
                    for (int i = 0; i < temp.length; i++) {
                        result[i] = temp[i];
                    }
                }
            }
            count++;
        }
        return result;
    }

    /**
     * 贪心求最大值
     *
     * @param num
     * @param k
     * @return
     */
    private int[] getMaxVal(int[] num, int k) {
        if (k == 0) {
            return new int[0];
        }
        int[] result = new int[k];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < num.length; i++) {
            if (stack.isEmpty()) {
                stack.push(num[i]);
            } else {
                while (!stack.isEmpty() && stack.peek() < num[i] && stack.size() + num.length - i > k) {
                    stack.pop();
                }
                if (stack.size() < k) {
                    stack.push(num[i]);
                }
            }
        }
        for (int i = k - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }

    /**
     * 合并两个数组
     *
     * @param num1
     * @param num2
     * @return
     */
    private int[] mergeArray(int[] num1, int[] num2) {
        int length1 = num1.length, length2 = num2.length, p = 0, q = 0, index = 0;
        if (length1 == 0) {
            return num2;
        }
        if (length2 == 0) {
            return num1;
        }
        int[] result = new int[length1 + length2];
        for (int i = 0; i < result.length; i++) {
            if (compare(num1, p, num2, q) > 0) {
                result[index++] = num1[p++];
            } else {
                result[index++] = num2[q++];
            }
        }
        return result;
    }

    private int compare(int[] num1, int index1, int[] num2, int index2) {
        int length1 = num1.length, length2 = num2.length;
        while (index1 < length1 && index2 < length2) {
            int diff = num1[index1] - num2[index2];
            if (diff != 0) {
                return diff;
            }
            index1++;
            index2++;
        }
        return (length1 - index1) - (length2 - index2);
    }

    /**
     * 比较两个数组的大小
     *
     * @param num1
     * @param num2
     * @return
     */
    private boolean judge(int[] num1, int[] num2) {
        for (int i = 0; i < num1.length; i++) {
            if (num1[i] > num2[i]) {
                return true;
            }
            if (num1[i] < num2[i]) {
                return false;
            }
        }
        return false;
    }

}
