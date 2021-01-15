package algorithm.greedy;

import java.util.Arrays;

/**
 * @author qihaodong
 */
public class LeetCode452 {

    /**
     * 贪心算法
     *
     * @param points
     * @return
     */
    public int findMinArrowShots(int[][] points) {
        if (points.length < 2) {
            return points.length;
        }
        Arrays.sort(points, (o1, o2) -> {
            if (o1[1] > o2[1]) {
                return 1;
            } else if (o1[1] < o2[1]) {
                return -1;
            } else {
                return 0;
            }
        });
        int start = points[0][1];
        int result = 1;
        for (int[] temp : points) {
            if (temp[0] > start) {
                start = temp[1];
                result++;
            }
        }
        return result;
    }

}
