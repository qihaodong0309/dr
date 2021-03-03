package algorithm.dichotomy;

/**
 * 同 JzOffer 42
 *
 * @author qihaodong
 */
public class LeetCode53 {

    /*
    JzOffer 中使用贪心算法，这里我们使用分治算法
     */

    /**
     * 分治算法
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        return getInfo(nums, 0, nums.length - 1).mSum;
    }

    private Status getInfo(int[] a, int l, int r) {
        if (l == r) {
            return new Status(a[l], a[l], a[l], a[l]);
        }
        int m = (l + r) / 2;
        Status lSta = getInfo(a, l, m);
        Status rSta = getInfo(a, m + 1, r);
        return merge(lSta, rSta);
    }

    private Status merge(Status s1, Status s2) {
        int iSum = s1.iSum + s2.iSum;
        int lSum = Math.max(s1.lSum, s1.iSum + s2.lSum);
        int rSum = Math.max(s2.rSum, s2.iSum + s1.rSum);
        int mSum = Math.max(Math.max(s1.mSum, s2.mSum), s1.rSum + s2.lSum);
        return new Status(lSum, rSum, mSum, iSum);
    }

    class Status {

//        lSum 表示 [l,r][l,r] 内以 ll 为左端点的最大子段和
//        rSum 表示 [l,r][l,r] 内以 rr 为右端点的最大子段和
//        mSum 表示 [l,r][l,r] 内的最大子段和
//        iSum 表示 [l,r][l,r] 的区间和

        int lSum, rSum, mSum, iSum;

        public Status(int lSum, int rSum, int mSum, int iSum) {
            this.lSum = lSum;
            this.rSum = rSum;
            this.mSum = mSum;
            this.iSum = iSum;
        }

    }

}
