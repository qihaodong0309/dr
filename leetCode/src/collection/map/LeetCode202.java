package collection.map;

import java.util.HashSet;
import java.util.Set;

/**
 * @author qihaodong
 */
public class LeetCode202 {

    /**
     * 基于 HashSet
     *
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet();
        while (!set.contains(n)) {
            set.add(n);
            int temp = 0;
            while (n != 0) {
                int num = n % 10;
                temp += num * num;
                n = n / 10;
            }
            if (temp == 1) {
                return true;
            }
            n = temp;
        }
        return false;
    }

    /**
     * 快慢指针法
     *
     * @param n
     * @return
     */
    public boolean isHappy2(int n) {
        int slow = n, quick = getNext(n);
        while (quick != 1 && slow != quick) {
            slow = getNext(slow);
            quick = getNext(getNext(quick));
        }
        return quick == 1;
    }

    private int getNext(int n) {
        int result = 0;
        while (n > 0) {
            int temp = n % 10;
            result += temp * temp;
            n /= 10;
        }
        return result;
    }

}
