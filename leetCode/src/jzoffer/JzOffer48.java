package jzoffer;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 同 LeetCode 3
 *
 * @author qihaodong
 */
public class JzOffer48 {

    /**
     * 贪心算法
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] cs = s.toCharArray();
        Queue<Character> queue = new LinkedList() {{
            add(cs[0]);
        }};
        int result = 1;
        for (int i = 1; i < cs.length; i++) {
            if (queue.contains(cs[i])) {
                while (queue.poll() != cs[i]) {
                }
            }
            queue.add(cs[i]);
            result = Math.max(result, queue.size());
        }
        return result;
    }

    /*
    以下做法都是来自 K神 dp
     */

    public int lengthOfLongestSubstring2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int result = 0, temp = 0;
        for (int j = 0; j < s.length(); j++) {
            int i = map.getOrDefault(s.charAt(j), -1);
            map.put(s.charAt(j), j);
            temp = temp < j - i ? temp + 1 : j - i;
            result = Math.max(result, temp);
        }
        return result;
    }


    public int lengthOfLongestSubstring3(String s) {
        int result = 0, temp = 0;
        for (int j = 0; j < s.length(); j++) {
            int i = j - 1;
            while (i >= 0 && s.charAt(i) != s.charAt(j)) {
                i--;
            }
            temp = temp < j - i ? temp + 1 : j - i;
            result = Math.max(result, temp);
        }
        return result;
    }

    public int lengthOfLongestSubstring4(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int result = 0, i = -1;
        for (int j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(i, map.get(s.charAt(j)));
            }
            map.put(s.charAt(j), j);
            result = Math.max(result, j - i);
        }
        return result;
    }

}
