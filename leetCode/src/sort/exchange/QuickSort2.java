package sort.exchange;

import java.util.Random;

/**
 * @author qihaodong
 */
public class QuickSort2 {

    public static void main(String[] args) {
        QuickSort2 sort = new QuickSort2();
        int[] a = new int[20];
        for (int i = 0; i < a.length; i++) {
            a[i] = new Random().nextInt(100);
        }
        sort.echo(a, 0, 19);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    private void echo(int[] a, int left, int right) {
        if (left >= right) {
            return;
        }
        // 越过相等的基准数值
        int index = sort(a, left, right), l = index - 1, r = index + 1;
        while (l > left && a[l] == a[index]) {
            l--;
        }
        while (r < right && a[r] == a[index]) {
            r++;
        }
        echo(a, left, l);
        echo(a, r, right);
    }

    private int sort(int[] a, int left, int right) {
        int key = a[left], l = left, r = right;
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
        // 交换逻辑
        int p = left - 1, q = right + 1;
        while (l < p) {
            if (a[l] == key) {
                while (p > l && a[p] == key) {
                    p--;
                }
                sawp(a, l, p);
            }
            l++;
        }
        while (r > q) {
            if (a[r] == key) {
                while (q < r && a[q] == key) {
                    p++;
                }
                sawp(a, r, q);
            }
            r--;
        }
        return left;
    }

    private void sawp(int[] n, int x, int y) {
        if (x == y) {
            return;
        }
        int z = n[x];
        n[x] = n[y];
        n[y] = z;
    }

}
