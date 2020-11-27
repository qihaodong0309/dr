package exchange;

import java.util.Random;

/**
 * 冒泡排序
 *
 * @author qihaodong
 */
public class BubbleSort {

    public static void main(String[] args) {
        BubbleSort sort = new BubbleSort();
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
     * 内层循环比较相邻元素，如果前一个大于后一个就交换
     * 外层循环每次少遍历一个元素
     * 每轮循环都会将最大的元素交换到数组末尾
     *
     * @param a
     */
    private void sort(int[] a) {
        for (int i = 1; i <= a.length - 1; i++) {
            for (int j = 0; j < a.length - i; j++) {
                if (a[j] > a[j + 1]) {
                    int k = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = k;
                }
            }
        }
    }

}
