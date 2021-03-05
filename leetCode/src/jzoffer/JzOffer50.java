package jzoffer;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author qihaodong
 */
public class JzOffer50 {

    /**
     * 返回字符（有序哈希表）
     *
     * @param s
     * @return
     */
    public char firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return ' ';
        }
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for (char c : map.keySet()) {
            if (map.get(c) == 1) {
                return c;
            }
        }
        return ' ';
    }

    /**
     * 返回索引
     *
     * @param s
     * @return
     */
    public int firstUniqChar2(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, -1);
            } else {
                map.put(c, i);
            }
        }
        for (char c : map.keySet()) {
            if (map.get(c) >= 0) {
                return map.get(c);
            }
        }
        return -1;
    }

}
