package sort.insert;

import java.util.Random;

/**
 * @author qihaodong
 */
public class HillSort {

    public static void main(String[] args) {
        HillSort sort = new HillSort();
        int[] a = new int[100];
        for (int i = 0; i < a.length; i++) {
            a[i] = new Random().nextInt(1000);
        }
        sort.sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    /**
     * 希尔排序本质上还是直接插入排序
     * 希尔排序分别以间隔 N，N/2,....1 来进行直接插入排序
     * 其中 N 初始值一般选数组长度的一半
     * 这样做的好处是减少遍历次数，通过外层间隔比较大的比较，使整个数组局部有序
     * 后面当间隔等于1时实际上就是直接插入排序
     *
     * @param a
     */
    private void sort(int[] a) {
        int n = a.length, record = n / 2;
        while (record >= 1) {
            for (int i = record; i < n; i++) {
                int k = a[i], j = i - record;
                if (j >= 0 && a[j] > k) {
                    a[j + record] = a[j];
                    j -= record;
                }
                if (j != i - record) {
                    a[j + record] = k;
                }
            }
            record /= 2;
        }
    }

}
