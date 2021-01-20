package collection.array;

/**
 * @author qihaodong
 */
public class LeetCode88 {

    /**
     * 第一反应，从后往前合并
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int length = nums1.length;
        int index = nums1.length - 1, index1 = m - 1, index2 = n - 1;
        while (index2 >= 0) {
            while (index1 >= 0 && index2 >= 0) {
                if (nums1[index1] >= nums2[index2]) {
                    nums1[index--] = nums1[index1--];
                } else {
                    nums1[index--] = nums2[index2--];
                }
            }
            while (index2 >= 0) {
                nums1[index--] = nums2[index2--];
            }
        }
    }

}
