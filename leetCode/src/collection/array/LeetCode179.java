package collection.array;

import java.util.Arrays;

/**
 * @author qihaodong
 */
public class LeetCode179 {

    /**
     * 数组排列法
     *
     * @param nums
     * @return
     */
    public String largestNumber(int[] nums) {
        int n = nums.length;
        Integer[] integers = new Integer[n];
        for (int i = 0; i < n; i++) {
            integers[i] = nums[i];
        }
        Arrays.sort(integers, (x, y) -> {
            long a = 10, b = 10;
            while (a <= x) {
                a *= 10;
            }
            while (b < y) {
                b *= 10;
            }
            return (int) (-b * x - a + -a * y + b);
        });
        if (integers[0] == 0) {
            return "0";
        }
        StringBuilder result = new StringBuilder();
        for (int temp : integers) {
            result.append(temp);
        }
        return result.toString();
    }

}
