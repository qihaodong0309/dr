package greedy;

import java.util.Arrays;

/**
 * @author qihaodong
 */
public class LeetCode455 {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int result = 0, gIndex = g.length - 1, sIndex = s.length - 1;
        while (gIndex >= 0 && sIndex >= 0) {
            if (s[sIndex] >= g[gIndex]) {
                sIndex--;
                result++;
            }
            gIndex--;
        }
        return result;
    }

}
