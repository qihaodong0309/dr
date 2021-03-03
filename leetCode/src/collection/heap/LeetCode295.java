package collection.heap;

/**
 * 同 JzOffer 41
 *
 * @author qihaodong
 */
public class LeetCode295 {

    public static void main(String[] args) {
        MedianFinder test = new MedianFinder();
        test.addNum(-1);
        System.out.println(test.findMedian());
        test.addNum(-2);
        System.out.println(test.findMedian());
        test.addNum(-3);
        System.out.println(test.findMedian());
        test.addNum(-4);
        System.out.println(test.findMedian());
        test.addNum(-5);
        System.out.println(test.findMedian());
    }

    /*
    JzOffer 中采用双栈法，这里我们使用双向链表
     */

    static class MedianFinder {

        public MedianFinder() {

        }

        Node head = new Node(-1), end = null, temp = null;
        int size = 0;

        public void addNum(int num) {
            if (size == 0) {
                Node node = new Node(num, head, null);
                head.right = node;
                end = node;
            } else {
                if (num >= end.val) {
                    Node node = new Node(num, end, null);
                    end.right = node;
                    end = node;
                } else {
                    temp = head;
                    do {
                        temp = temp.right;
                    } while (num > temp.val);
                    Node node = new Node(num, temp.left, temp);
                    temp.left.right = node;
                    temp.left = node;
                }
            }
            size++;
        }

        public double findMedian() {
            temp = head;
            if (size % 2 == 1) {
                for (int i = 0; i < size / 2 + 1; i++) {
                    temp = temp.right;
                }
                return temp.val;
            } else {
                for (int i = 0; i < size / 2; i++) {
                    temp = temp.right;
                }
                return (temp.val + temp.right.val) / 2.0;
            }
        }

        class Node implements Comparable<Node> {

            int val;
            Node left;
            Node right;

            public Node(int val) {
                this.val = val;
            }

            public Node(int val, Node left, Node right) {
                this.val = val;
                this.left = left;
                this.right = right;
            }

            @Override
            public int compareTo(Node o) {
                return this.val - o.val;
            }
        }

    }

}
