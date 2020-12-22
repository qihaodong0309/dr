package array;

import java.util.Random;

/**
 * @author qihaodong
 */
public class LeetCode384 {

    public LeetCode384(int[] nums) {
        result = nums;
        record = result.clone();
    }

    int[] result = null;
    int[] record = null;

    Random random = new Random();

    public int[] reset() {
        result = record;
        record = result.clone();
        return result;
    }

    public int[] shuffle() {
        for (int i = 0; i < result.length; i++) {
            swap(result, i, random.nextInt(result.length));
        }
        return result;
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
