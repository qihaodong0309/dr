package algorithm.base;

import java.util.HashSet;
import java.util.Set;

/**
 * 同 JzOffer 48
 *
 * @author qihaodong
 */
public class LeetCode3 {

    /**
     * 贪心思路
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int result = 0, left = -1, right = s.length();
        for (int i = 0; i < s.length(); i++) {
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }
            while (left + 1 < right && !set.contains(s.charAt(left + 1))) {
                set.add(s.charAt(left + 1));
                left++;
            }
            result = Math.max(result, left - i + 1);
        }
        return result;
    }

}
