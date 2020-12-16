package string;

import java.util.HashMap;

/**
 * @author qihaodong
 */
public class LeetCode290 {

    public boolean wordPattern(String pattern, String s) {
        char[] temp = pattern.toCharArray();
        String[] strings = s.split(" ");
        if (temp.length != strings.length) {
            return false;
        }
        HashMap<Character, String> map = new HashMap();
        for (int i = 0; i < temp.length; i++) {
            if (map.containsKey(temp[i])) {
                String judge = map.get(temp[i]);
                if (!judge.equals(strings[i])) {
                    return false;
                }
            } else {
                if (map.values().contains(strings[i])) {
                    return false;
                }
                map.put(temp[i], strings[i]);
            }
        }
        return true;
    }

}
