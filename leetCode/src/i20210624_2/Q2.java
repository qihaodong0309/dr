package i20210624_2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qihaodong
 */
public class Q2 {

    /**
     * 借助 Set
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap();
        for (int n : nums1) {
            map.put(n, 1);
        }
        int num = 0, k = 0;
        for (int n : nums2) {
            if (map.containsKey(n) && map.get(n) == 1) {
                map.put(n, 2);
                num++;
            }
        }
        int[] result = new int[num];
        for (int n : map.keySet()) {
            if (map.get(n) == 2) {
                result[k++] = n;
            }
        }
        return result;
    }

}
