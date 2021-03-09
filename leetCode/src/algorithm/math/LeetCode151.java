package algorithm.math;

import java.util.*;

/**
 * 同 JzOffer 58_1
 *
 * @author qihaodong
 */
public class LeetCode151 {

    public static void main(String[] args) {
        LeetCode151 test = new LeetCode151();
        test.reverseWords2("  hello world!  ");
    }

    /**
     * 官方解法
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        s = s.trim();
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }

    /**
     * 使用队列
     *
     * @param s
     * @return
     */
    public String reverseWords2(String s) {
        Deque<String> deque = new ArrayDeque<>();
        StringBuffer sb = new StringBuffer();
        s = s.trim();
        int start = 0, end = s.length() - 1;
        while (start <= end) {
            char c = s.charAt(start);
            if (sb.length() != 0 && c == ' ') {
                deque.offerFirst(sb.toString());
                sb.setLength(0);
            } else if (c != ' ') {
                sb.append(c);
            }
            start++;
        }
        deque.offerFirst(sb.toString());
        return String.join(" ", deque);
    }

}
