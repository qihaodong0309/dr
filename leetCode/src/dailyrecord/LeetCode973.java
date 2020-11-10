package dailyrecord;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author qihaodong
 */
public class LeetCode973 {

    public static void main(String[] args) {
        int[][] a = {{1, 3}, {-2, 2}};
        System.out.println(new LeetCode973().kClosest(a, 2));
    }

    /**
     * 链表法
     *
     * @param points
     * @param K
     * @return
     */
    public int[][] kClosest(int[][] points, int K) {
        int[][] result = new int[K][2];
        Node head = new Node(0, 0), temp = head;
        int num = 0;
        for (int i = 0; i < points.length; i++) {
            Node n = new Node(points[i][0], points[i][1]);
            temp = head;
            num = 0;
            while (temp.next != null && temp.next.val < n.val && num < K) {
                num++;
                temp = temp.next;
            }
            if (num == K) {
                continue;
            }
            n.next = temp.next;
            temp.next = n;
        }
        for (int i = 1; i <= K; i++) {
            head = head.next;
            result[i - 1][0] = head.x;
            result[i - 1][1] = head.y;
        }
        return result;
    }

    private class Node {

        int x, y, val;
        Node next;

        private Node(int x, int y) {
            this.x = x;
            this.y = y;
            this.val = x * x + y * y;
        }
    }

    /**
     * 被代替的堆排序
     *
     * @param points
     * @param K
     * @return
     */
    public int[][] kClosest2(int[][] points, int K) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });
        for (int i = 0; i < K; i++) {
            queue.offer(new int[]{points[i][0] * points[i][0] + points[i][1] * points[i][1], i});
        }
        int n = points.length;
        for (int i = K; i < n; i++) {
            int dist = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            if (dist < queue.peek()[0]) {
                queue.poll();
                queue.offer(new int[]{dist, i});
            }
        }
        int[][] result = new int[K][2];
        for (int i = 0; i < K; i++) {
            result[i] = points[queue.poll()[1]];
        }
        return result;
    }

}
