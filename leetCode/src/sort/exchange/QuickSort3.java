package sort.exchange;

/**
 * @author qihaodong
 */
public class QuickSort3 {

    class DemoThread implements Runnable {

        private int[] a;
        int left;
        int right;

        public DemoThread(int[] a, int left, int right) {
            this.a = a;
            this.left = left;
            this.right = right;
        }

        @Override
        public void run() {
            int index = sort(a, left, right);
            if (left < index - 1) {
                new Thread(new DemoThread(a, left, index - 1)).start();
            }
            if (index + 1 > right) {
                new Thread(new DemoThread(a, index + 1, right)).start();
            }
        }

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


}
