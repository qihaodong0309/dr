package jzoffer;

import java.util.*;

/**
 * @author qihaodong
 */
public class JzOffer38 {

    public static void main(String[] args) {
        JzOffer38 test = new JzOffer38();
        test.permutation("abc");
    }

    /**
     * 递归解决（会超时）
     *
     * @param s
     * @return
     */
    public String[] permutation(String s) {
        List<String> result = new ArrayList<>();
        echo(s, "", result);
        return result.toArray(new String[result.size()]);
    }

    private void echo(String s, String str, List<String> result) {
        if (s.length() == 1) {
            str += s;
            if (!result.contains(str)) {
                result.add(str);
                return;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            String newS = s.substring(0, i) + s.substring(i + 1 > s.length() ? i : i + 1);
            String newStr = str + s.charAt(i);
            echo(newS, newStr, result);
        }
    }

    /**
     * 回溯法
     *
     * @param s
     * @return
     */
    public String[] permutation2(String s) {
        if (s.isEmpty() || s.equals("")) {
            return new String[0];
        }
        boolean[] record = new boolean[s.length()];
        echo2(s, "", record);
        return set.toArray(new String[set.size()]);
    }

    Set<String> set = new HashSet<>();

    private void echo2(String s, String temp, boolean[] record) {
        if (s.length() == temp.length()) {
            set.add(temp);
            return;
        }
        for (int i = 0; i < record.length; i++) {
            if (record[i]) {
                continue;
            }
            record[i] = true;
            echo2(s, temp + s.charAt(i), record);
            record[i] = false;
        }
    }

    /**
     * dfs（自带去重）
     *
     * @param s
     * @return
     */
    public String[] permutation3(String s) {
        chars = s.toCharArray();
        dfs(0);
        return result.toArray(new String[result.size()]);
    }

    List<String> result = new LinkedList<>();
    char[] chars = null;

    private void dfs(int x) {
        if (x == chars.length - 1) {
            result.add(String.valueOf(chars));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = x; i < chars.length; i++) {
            if (set.contains(chars[i])) {
                continue;
            }
            set.add(chars[i]);
            swap(i, x);
            dfs(x + 1);
            swap(i, x);
        }
    }

    void swap(int a, int b) {
        char temp = chars[a];
        chars[a] = chars[b];
        chars[b] = temp;
    }

}
