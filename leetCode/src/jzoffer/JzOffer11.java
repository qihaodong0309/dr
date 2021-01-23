package jzoffer;

/**
 * @author qihaodong
 */
public class JzOffer11 {

    /**
     * 通过遍历方法
     *
     * @param numbers
     * @return
     */
    public int minArray(int[] numbers) {
        int result = numbers[0];
        for (int i = 1; i < numbers.length; ++i) {
            if (numbers[i] < numbers[i - 1]) {
                result = numbers[i];
                break;
            }
        }
        return result;
    }

    /**
     * 使用二分法
     *
     * @param numbers
     * @return
     */
    public int minArray2(int[] numbers) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] < numbers[right]) {
                right = mid;
            } else if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else {
                right = right - 1;
            }
        }
        return numbers[left];
    }

}
