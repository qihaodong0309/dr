package dailyrecord;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author qihaodong
 */
public class LeetCode406 {

    /**
     * 从小到大考虑
     *
     * @param people
     * @return
     */
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    return o2[1] - o1[1];
                }
            }
        });
        int length = people.length;
        int[][] result = new int[length][];
        for (int[] temp : people) {
            int index = temp[1] + 1;
            for (int i = 0; i < length; i++) {
                if (result[i] == null) {
                    index--;
                    if (index == 0) {
                        result[i] = temp;
                        break;
                    }
                }
            }
        }
        return result;
    }

    /**
     * 从大到小考虑
     *
     * @param people
     * @return
     */
    public int[][] reconstructQueue2(int[][] people) {
        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o2[0] - o1[0];
            } else {
                return o1[1] - o2[1];
            }
        });
        List<int[]> result = new ArrayList<int[]>();
        for (int[] temp : people) {
            result.add(temp[1], temp);
        }
        return result.toArray(new int[result.size()][]);
    }

}
