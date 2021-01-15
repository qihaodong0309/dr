package collection.heap;

import java.util.*;

/**
 * @author qihaodong
 */
public class LeetCode347 {

    /**
     * 基于堆实现
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<Map.Entry<Integer, Integer>>((Map.Entry<Integer, Integer> entry1, Map.Entry<Integer, Integer> entry2) -> {
            return entry2.getValue() - entry1.getValue();
        });
        HashMap<Integer, Integer> map = new HashMap(15);
        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        for (Map.Entry entry : map.entrySet()) {
            heap.add(entry);
        }
        for (int i = 0; i < k; i++) {
            result[i] = heap.poll().getKey();
        }
        return result;
    }

    /**
     * 堆改为快速排序
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent2(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        List<int[]> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            list.add(new int[]{key, value});
        }
        quickSort(list, 0, list.size() - 1, result, 0, k);
        return result;
    }

    private void quickSort(List<int[]> list, int start, int end, int[] result, int index, int num) {
        int temp = start, judge = list.get(start)[1];
        for (int i = start + 1; i <= end; i++) {
            if (list.get(i)[1] >= judge) {
                Collections.swap(list, temp + 1, i);
                temp++;
            }
        }
        Collections.swap(list, start, temp);
        if (num < temp - start) {
            quickSort(list, start, temp - 1, result, index, num);
        } else if (num == temp - start) {
            for (int i = start; i < temp; i++) {
                result[index++] = list.get(i)[0];
            }
        } else {
            for (int i = start; i <= temp; i++) {
                result[index++] = list.get(i)[0];
            }
            if (num > temp - start + 1) {
                quickSort(list, temp + 1, end, result, index, num - (temp - start + 1));
            }
        }
    }
}
