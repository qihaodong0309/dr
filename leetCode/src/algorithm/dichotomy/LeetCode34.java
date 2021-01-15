package algorithm.dichotomy;

/**
 * @author qihaodong
 */
public class LeetCode34 {

    public static void main(String[] args) {
        new LeetCode34().searchRange2(new int[]{5, 7, 7, 8, 8, 10}, 8);
    }

    /**
     * 二分法，然而该方法在全部都是目标值时时间复杂度为 O(n)，不满足题意，因此我们优化一下
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int left = 0, right = nums.length - 1, record = -1;
        while (left <= right) {
            int mid = (right - left + 1) / 2 + left;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                record = mid;
                break;
            }
        }
        if (record != -1) {
            int p = record, q = record;
            while (p >= 0 && nums[p] == target) {
                p--;
            }
            while (q < nums.length && nums[q] == target) {
                q++;
            }
            return new int[]{p + 1, q - 1};
        }
        return new int[]{-1, -1};
    }

    /**
     * 优化后的方法为找到第一个小于目标值的小标和第一个大于目标值的下标
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange2(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int left = 0, right = nums.length - 1, index1 = -1, index2 = -1;
        while (left <= right) {
            int mid = (right - left + 1) / 2 + left;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                right = mid - 1;
                index1 = mid;
            } else {
                left = mid + 1;
            }
        }
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left + 1) / 2 + left;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                left = mid + 1;
                index2 = mid;
            } else {
                left = mid + 1;
            }
        }
        if (index1 != -1 && index2 != -1) {
            return new int[]{index1, index2};
        }
        return new int[]{-1, -1};
    }

    /**
     * 公共二分方法提出
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange3(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int index1 = getVal(nums, target, true);
        int index2 = getVal(nums, target, false);
        if (index1 != -1 && index2 != -1) {
            return new int[]{index1, index2};
        }
        return new int[]{-1, -1};
    }

    /**
     * 上述方法可以优化，因为写了两段类似的代码，所以可以提出来
     *
     * @param nums
     * @param target
     * @param judge
     * @return
     */
    private int getVal(int[] nums, int target, boolean judge) {
        int left = 0, right = nums.length - 1, result = -1;
        while (left <= right) {
            int mid = (right - left + 1) / 2 + left;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                if (judge) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
                result = mid;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

}
