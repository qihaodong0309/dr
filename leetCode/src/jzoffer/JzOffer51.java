package jzoffer;

/**
 * @author qihaodong
 */
public class JzOffer51 {

    /**
     * K神解法（归并排序）
     *
     * @param nums
     * @return
     */
    public int reversePairs(int[] nums) {
        this.nums = nums;
        temp = new int[nums.length];
        return mergeSort(0, nums.length - 1);
    }

    int[] nums, temp;

    private int mergeSort(int l, int r) {
        if (l >= r) {
            return 0;
        }
        int m = (l + r) / 2, i = l, j = m + 1;
        int result = mergeSort(l, m) + mergeSort(m + 1, r);
        for (int k = l; k <= r; k++) {
            temp[k] = nums[k];
        }
        for (int k = l; k <= r; k++) {
            if (i == m + 1) {
                nums[k] = temp[j++];
            } else if (j == r + 1 || temp[i] <= temp[j]) {
                nums[k] = temp[i++];
            } else {
                nums[k] = temp[j++];
                result += m - i + 1;
            }
        }
        return result;
    }

}
