package jzoffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qihaodong
 */
public class JzOffer57_2 {

    /**
     * K神，滑动窗口
     *
     * @param target
     * @return
     */
    public int[][] findContinuousSequence(int target) {
        int i = 1, j = 2, s = 3;
        List<int[]> list = new ArrayList();
        while (i < j) {
            if (s == target) {
                int[] temp = new int[j - i + 1];
                for (int k = i; k <= j; k++) {
                    temp[k - i] = k;
                }
                list.add(temp);
            }
            if (s >= target) {
                s -= i++;
            } else {
                s += ++j;
            }
        }
        return list.toArray(new int[0][]);
    }

    /**
     * K神数学解法
     *
     * @param target
     * @return
     */
    public int[][] findContinuousSequence2(int target) {
        int i = 1;
        double j = 2.0;
        List<int[]> list = new ArrayList<>();
        while (i < j) {
            j = (-1 + Math.sqrt(1 + 4 * (2 * target + (long) i * i - i))) / 2;
            if (j == (int) j) {
                int[] temp = new int[(int) j - i + 1];
                for (int k = i; k <= j; k++) {
                    temp[k - i] = k;
                }
                list.add(temp);
            }
            i++;
        }
        return list.toArray(new int[0][]);
    }

}
