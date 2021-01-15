package algorithm.greedy;

import java.util.PriorityQueue;

/**
 * @author qihaodong
 */
public class LeetCode767 {

    /*
    对于本题而言，只要不存在字符的数量大于字符串长度加一的一半，就不可能返回空
    贪心算法在这里只是为了方便找出一个满足条件的字符串
     */

    /**
     * 基于最大堆的贪心算法
     *
     * @param S
     * @return
     */
    public String reorganizeString(String S) {
        int n = S.length();
        char[] record = new char[26];
        for (char c : S.toCharArray()) {
            record[c - 'a']++;
            if (record[c - 'a'] > (n + 1) / 2) {
                return "";
            }
        }
        PriorityQueue<Character> queue = new PriorityQueue<>((Character o1, Character o2) -> {
            return record[o2 - 'a'] - record[o1 - 'a'];
        });
        for (int i = 0; i < record.length; i++) {
            if (record[i] > 0) {
                char temp = (char) ('a' + i);
                queue.offer(temp);
            }
        }
        StringBuffer sb = new StringBuffer();
        while (queue.size() > 1) {
            char c1 = queue.poll();
            char c2 = queue.poll();
            record[c1 - 'a']--;
            record[c2 - 'a']--;
            if (record[c1 - 'a'] > 0) {
                queue.offer(c1);
            }
            if (record[c2 - 'a'] > 0) {
                queue.offer(c2);
            }
            sb.append(c1);
            sb.append(c2);
        }
        if (!queue.isEmpty()) {
            sb.append(queue.poll());
        }
        return sb.toString();
    }

    /**
     * 基于下标的贪心算法
     * 对于长度为偶数的字符串，单个字符最大出现数量为 n/2 ,此时无论奇数下标还是偶数下标都可以
     * 对于长度为奇数的字符串，单子字符最大出现数量为 (n+1)/2 ,此时它必须在偶数下标，否则会报错
     *
     * @param S
     * @return
     */
    public String reorganizeString2(String S) {
        int n = S.length(), left = 0, right = 1;
        char[] record = new char[26];
        for (char c : S.toCharArray()) {
            record[c - 'a']++;
            if (record[c - 'a'] > (n + 1) / 2) {
                return "";
            }
        }
        char[] result = new char[n];
        for (int i = 0; i < record.length; i++) {
            char temp = (char) ('a' + i);
            while (record[i] > 0 && record[i] <= n / 2 && right < n) {
                result[right] = temp;
                right += 2;
                record[i]--;
            }
            while (record[i] > 0 && left < n) {
                result[left] = temp;
                left += 2;
                record[i]--;
            }
        }
        return new String(result);
    }

}
