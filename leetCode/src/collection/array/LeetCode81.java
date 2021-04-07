package collection.array;

/**
 * @author qihaodong
 */
public class LeetCode81 {

    public static void main(String[] args) {
        LeetCode81 test = new LeetCode81();
        test.search2(new int[]{1, 0, 1, 1, 1}, 0);
    }

    /**
     * 遍历法
     *
     * @param nums
     * @param target
     * @return
     */
    public boolean search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return true;
            }
        }
        return false;
    }

    /**
     * 二分法
     *
     * @param nums
     * @param target
     * @return
     */
    public boolean search2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        return judge(nums, 0, nums.length - 1, target);
    }

    private boolean judge(int[] nums, int start, int end, int target) {
        if (start > end) {
            return false;
        }
        int mid = (start + end) / 2;
        if (nums[mid] == target) {
            return true;
        }
        if (nums[start] == nums[mid] && nums[end] == nums[mid]) {
            return judge(nums, start + 1, end - 1, target);
        }
        if (nums[start] <= nums[mid]) {
            if (nums[start] <= target && nums[mid] > target) {
                return judge(nums, start, mid - 1, target);
            } else {
                return judge(nums, mid + 1, end, target);
            }
        } else {
            if (nums[mid] < target && target <= nums[nums.length - 1]) {
                return judge(nums, mid + 1, end, target);
            } else {
                return judge(nums, start, mid - 1, target);
            }
        }
    }

}
