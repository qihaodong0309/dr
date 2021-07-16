package dp.type6;

/**
 * @author qihaodong
 */
public class LeetCode801 {

    /**
     * 动态规划
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int minSwap(int[] nums1, int[] nums2) {
        int n1 = 0, s1 = 1;
        for (int i = 1; i < nums1.length; ++i) {
            int n2 = Integer.MAX_VALUE, s2 = Integer.MAX_VALUE;
            if (nums1[i - 1] < nums1[i] && nums2[i - 1] < nums2[i]) {
                n2 = Math.min(n2, n1);
                s2 = Math.min(s2, s1 + 1);
            }
            if (nums1[i - 1] < nums2[i] && nums2[i - 1] < nums1[i]) {
                n2 = Math.min(n2, s1);
                s2 = Math.min(s2, n1 + 1);
            }
            n1 = n2;
            s1 = s2;
        }
        return Math.min(n1, s1);
    }

}
