package jzoffer;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author qihaodong
 */
public class JzOffer40 {

    public static void main(String[] args) {
        JzOffer40 test = new JzOffer40();
        test.getLeastNumbers3(new int[]{3, 2, 1}, 2);
    }

    /**
     * 传统排序法
     *
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k == arr.length) {
            return arr;
        }
        Arrays.sort(arr);
        int[] result = Arrays.copyOf(arr, k);
        return result;
    }

    /**
     * 基于最小堆
     *
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers2(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k == arr.length) {
            return arr;
        }
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        for (int i = 0; i < arr.length; i++) {
            heap.add(arr[i]);
        }
        int[] result = new int[k];
        int index = 0;
        while (index < k) {
            result[index++] = heap.poll();
        }
        return result;
    }

    /**
     * 基于快速排序
     *
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers3(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k == arr.length) {
            return arr;
        }
        quickSort(arr, 0, arr.length - 1, k);
        return Arrays.copyOf(arr, k);
    }

    private void quickSort(int[] arr, int start, int end, int k) {
        if (start >= end) {
            return;
        }
        int mid = partition(arr, start, end);
        if (k == mid + 1) {
            return;
        } else if (k > mid + 1) {
            quickSort(arr, mid + 1, end, k);
        } else {
            quickSort(arr, start, mid - 1, k);
        }
    }

    private int partition(int[] nums, int left, int right) {
        int index = nums[left], temp = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] <= index) {
                swap(nums, temp + 1, i);
                temp++;
            }
        }
        swap(nums, left, temp);
        return temp;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
