package algorithm.dp;

import java.util.*;

/**
 * @author qihaodong
 */
public class LeetCode140 {

    /**
     * 回溯法（仍然超时）
     *
     * @param s
     * @param wordDict
     * @return
     */
    public List<String> wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        if (n == 0) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        echo(s, 0, n, new ArrayDeque<>(), result, wordDict);
        return result;
    }

    private void echo(String s, int start, int end, Deque<String> record, List<String> result, List<String> wordDict) {
        if (start == end) {
            StringBuffer sb = new StringBuffer();
            for (String temp : record) {
                if (sb.toString().length() == 0) {
                    sb.append(temp);
                } else {
                    sb.append(" " + temp);
                }
            }
            result.add(sb.toString());
        }
        for (int i = start + 1; i <= end; i++) {
            String temp = s.substring(start, i);
            if (judge(temp, wordDict)) {
                record.addLast(temp);
                echo(s, i, end, record, result, wordDict);
                record.removeLast();
            }
        }
    }

    private boolean judge(String s, List<String> list) {
        for (String temp : list) {
            if (s.equals(temp)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[] s = {"cat", "cats", "and", "sand", "dog"};
        new LeetCode140().wordBreak2("catsandog", Arrays.asList(s));
    }


    /**
     * dp 优化
     *
     * @param s
     * @param wordDict
     * @return
     */
    public List<String> wordBreak2(String s, List<String> wordDict) {
        int n = s.length();
        if (n == 0) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        List<List<String>> temp = echo(s, 0, n, new HashSet(wordDict), new HashMap());
        for (List<String> list : temp) {
            String ss = String.join(" ", list);
            result.add(ss);
        }
        return result;
    }

    private List<List<String>> echo(String s, int start, int end, Set<String> set,
                                    Map<Integer, List<List<String>>> map) {
        if (!map.containsKey(start)) {
            List<List<String>> newList = new ArrayList<>();
            if (start == end) {
                newList.add(new ArrayList<>());
            }
            for (int i = start + 1; i <= end; i++) {
                String temp = s.substring(start, i);
                if (set.contains(temp)) {
                    List<List<String>> oldlist = echo(s, i, end, set, map);
                    List<String> list = null;
                    for (List<String> ls : oldlist) {
                        list = new ArrayList<>();
                        list.add(temp);
                        list.addAll(ls);
                        newList.add(list);
                    }
                }
            }
            map.put(start, newList);
        }
        return map.get(start);
    }


}
