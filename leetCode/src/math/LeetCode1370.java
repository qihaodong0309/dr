package math;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author qihaodong
 */
public class LeetCode1370 {

    public static void main(String[] args) {
        System.out.println(new LeetCode1370().sortString("aaaabbbbcccc"));
    }

    /**
     * 计数，遍历法
     *
     * @param s
     * @return
     */
    public String sortString(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        TreeMap<Character, Integer> map = new TreeMap<>((o1, o2) -> {
            return (int) o1 - (int) o2;
        });
        for (Character c : s.toCharArray()) {
            if (map.containsKey(c)) {
                int val = map.get(c);
                map.put(c, val + 1);
            } else {
                map.put(c, 1);
            }
        }
        StringBuffer result = new StringBuffer();
        int record = 1;
        while (map.size() > 0) {
            StringBuffer str1 = new StringBuffer();
            Iterator iter = map.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                char key = (char) entry.getKey();
                int val = (int) entry.getValue();
                str1.append(key);
                if (val == 1) {
                    iter.remove();
                } else {
                    map.put(key, val - 1);
                }
            }
            if (record == 1) {
                result.append(str1.toString());
                record = 0;
            } else {
                result.append(str1.reverse().toString());
                record = 1;
            }
        }
        return result.toString();
    }

    /**
     * 代码优化
     *
     * @param s
     * @return
     */
    public String sortString2(String s) {
        int[] record = new int[26];
        for (char c : s.toCharArray()) {
            record[c - 'a']++;
        }
        StringBuffer result = new StringBuffer();
        while (result.length() < s.length()) {
            for (int i = 0; i < 26; i++) {
                if (record[i] > 0) {
                    result.append((char) (i + 'a'));
                    record[i]--;
                }
            }
            for (int i = 25; i >= 0; i--) {
                if (record[i] > 0) {
                    result.append((char) (i + 'a'));
                    record[i]--;
                }
            }
        }
        return result.toString();
    }

}
