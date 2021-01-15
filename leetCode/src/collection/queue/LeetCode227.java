package collection.queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author qihaodong
 */
public class LeetCode227 {

    public static void main(String[] args) {
        LeetCode227 test = new LeetCode227();
        test.calculate("0");
    }

    public int calculate(String s) {
        int result = 0, temp = 0, record = 0;
        Deque<Character> deque1 = new ArrayDeque<>();
        Deque<Integer> deque2 = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                continue;
            }
            if (c >= '0' && c <= '9') {
                temp = temp * 10 + (c - '0');
            } else {
                if (record != 0) {
                    int num = deque2.removeLast();
                    temp = record == 1 ? num * temp : num / temp;
                    record = 0;
                }
                deque2.addLast(temp);
                temp = 0;
                if (c == '+' || c == '-') {
                    deque1.add(c);
                } else {
                    record = c == '*' ? 1 : -1;
                }
            }
        }
        if (record != 0) {
            int num = deque2.removeLast();
            temp = record == 1 ? num * temp : num / temp;
        }
        deque2.addLast(temp);
        result = deque2.poll();
        while (!deque1.isEmpty()) {
            char c = deque1.poll();
            result = c == '+' ? result + deque2.poll() : result - deque2.poll();
        }
        return result;
    }

}
