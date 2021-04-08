package collection.array;

/**
 * @author qihaodong
 */
public class LeetCode153 {

    public static void main(String[] args) {
        LeetCode153 test = new LeetCode153();
        test.findMin2(new int[]{1, 2});
    }

    /**
     * 遍历法，找到第一个小于小于前几个的元素
     *
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                result = nums[i];
                break;
            }
        }
        return result;
    }

    /**
     * 二分法
     *
     * @param nums
     * @return
     */
    public int findMin2(int[] nums) {
        int index = judge(nums, 0, nums.length - 1, nums[0]);
        return nums[index == -1 ? 0 : index];
    }

    private int judge(int[] nums, int start, int end, int target) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (mid > 0 && nums[mid] < nums[mid - 1]) {
            return mid;
        }
        if (nums[mid] >= target) {
            return judge(nums, mid + 1, end, target);
        } else {
            return judge(nums, start, mid - 1, target);
        }
    }

}
