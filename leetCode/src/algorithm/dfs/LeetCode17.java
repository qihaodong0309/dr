package algorithm.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author qihaodong
 */
public class LeetCode17 {

    public static void main(String[] args) {
        List<String> list = new LeetCode17().letterCombinations("23");
        for (String s : list) {
            System.out.println(s);
        }
    }

    /**
     * dfs，字符串类型数据不是引用传递，无须回溯
     *
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        List<String> result = new ArrayList<>();
        if (digits == null || digits.equals("")) {
            return result;
        }
        dfs(result, map, digits, 0, "");
        return result;
    }

    private void dfs(List<String> list, HashMap<Integer, String> map, String s, int index, String temp) {
        if (temp.length() == s.length()) {
            list.add(temp);
            return;
        }
        int num = s.charAt(index) - '0';
        char[] chars = map.get(num).toCharArray();
        for (char c : chars) {
            String newTemp = temp + c;
            dfs(list, map, s, index + 1, newTemp);
        }
    }

}
