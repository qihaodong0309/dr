package collection.array;

/**
 * @author qihaodong
 */
public class LeetCode238 {

    /**
     * 反除法（题目不让使用）
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int record = 1, n = nums.length, num = 0;
        int[] result = new int[n];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                record *= nums[i];
            } else {
                num++;
                if (num > 1) {
                    return result;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (num == 0) {
                result[i] = record / nums[i];
            } else {
                result[i] = nums[i] == 0 ? record : 0;
            }
        }
        return result;
    }

    /**
     * 借助数据空间
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf2(int[] nums) {
        int[] result = new int[nums.length];
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        left[0] = 1;
        right[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < nums.length; i++) {
            result[i] = left[i] * right[i];
        }
        return result;
    }

    /**
     * 基于dp 思路，不借助额外空间
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf3(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        int temp = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] = result[i] * temp;
            temp = temp * nums[i];
        }
        return result;
    }

}
