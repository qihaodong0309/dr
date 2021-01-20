package sort.insert;

import java.util.Random;

/**
 * 直接插入排序
 *
 * @author qihaodong
 */
public class DirectInsertSort {

    public static void main(String[] args) {
        DirectInsertSort sort = new DirectInsertSort();
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
     * 外层循环表示每次插入一个元素
     * 内层循环从后往前遍历，直到找到第一个比它大的元素，将该元素插入当前位置
     *
     * @param a
     */
    private void sort(int[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            int k = a[i], j = i - 1;
            while (j >= 0 && a[j] > k) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = k;
        }
    }

}
