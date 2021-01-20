package sort.exchange;

import java.util.Random;

/**
 * 快速排序
 *
 * @author qihaodong
 */
public class QuickSort {

    public static void main(String[] args) {
        QuickSort sort = new QuickSort();
        int[] a = new int[100];
        for (int i = 0; i < a.length; i++) {
            a[i] = new Random().nextInt(1000);
        }
        sort.echo(a, 0, 99);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    /**
     * 找出基准点，此时该点左边的元素都小于该点值，该点右边的元素都大于该点值
     * 分别对左右两个数组进行排序
     *
     * @param a
     * @param left
     * @param right
     */
    private void echo(int[] a, int left, int right) {
        if (left >= right) {
            return;
        }
        int index = sort(a, left, right);
        echo(a, left, index - 1);
        echo(a, index + 1, right);
    }

    /**
     * 取第一个元素为基准点，保证左边都比它小，右边都比它大
     *
     * @param a
     * @param left
     * @param right
     * @return
     */
    private int sort(int[] a, int left, int right) {
        int key = a[left];
        while (left < right) {
            while (left < right && a[right] >= key) {
                right--;
            }
            a[left] = a[right];
            while (left < right && a[left] <= key) {
                left++;
            }
            a[right] = a[left];
        }
        a[left] = key;
        return left;
    }

}
