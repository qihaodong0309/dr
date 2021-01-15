package collection.array;

/**
 * @author qihaodong
 */
public class LeetCode189 {

    /**
     * 每次移动一步，共移动k次
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int n = nums.length;
        if (k == 0 || k % n == 0) {
            return;
        }
        while (k > 0) {
            int temp = nums[n - 1];
            for (int i = n - 1; i >= 1; i--) {
                nums[i] = nums[i - 1];
            }
            nums[0] = temp;
            k--;
        }
    }

    /**
     * 环装替代
     *
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k) {
        int n = nums.length, count = 0;
        k = k % n;
        for (int start = 0; count < n; start++) {
            int oldIndex = start, oldValue = nums[start];
            do {
                int newIndex = (oldIndex + k) % n;
                int newValue = nums[newIndex];
                nums[newIndex] = oldValue;
                oldValue = newValue;
                oldIndex = newIndex;
                count++;
            } while (start != oldIndex);
        }
    }


    /**
     * 反转
     *
     * @param nums
     * @param k
     */
    public void rotate3(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int k = nums[start];
            nums[start++] = nums[end];
            nums[end--] = k;
        }
    }

}
