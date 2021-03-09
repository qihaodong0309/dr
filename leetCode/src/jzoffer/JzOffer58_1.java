package jzoffer;

/**
 * 同 LeetCode 151
 *
 * @author qihaodong
 */
public class JzOffer58_1 {

    public static void main(String[] args) {
        JzOffer58_1 test = new JzOffer58_1();
        test.reverseWords("  hello world!  ");
    }

    /**
     * 基础方法
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        if (s == null || s.trim().length() == 0) {
            return "";
        }
        String[] strings = s.split("\\s+");
        int start = 0, end = strings.length - 1;
        while (start < end) {
            String temp = strings[start];
            strings[start++] = strings[end];
            strings[end--] = temp;
        }
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].trim().length() > 0) {
                result.append(" " + strings[i]);
            }
        }
        return result.toString().substring(1);
    }

    /**
     * K神解法 (双指针法)
     *
     * @param s
     * @return
     */
    public String reverseWords2(String s) {
        s.trim();
        int j = s.length() - 1, i = j;
        StringBuilder result = new StringBuilder();
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            result.append(s.substring(i + 1, j + 1) + " ");
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            j = i;
        }
        return result.toString().trim();
    }

    /**
     * K神解法（分割）
     *
     * @param s
     * @return
     */
    public String reverseWords3(String s) {
        String[] strings = s.trim().split(" ");
        StringBuffer result = new StringBuffer();
        for (int i = strings.length - 1; i >= 0; i--) {
            if (!strings[i].equals("")) {
                result.append(strings[i] + " ");
            }
        }
        return result.toString().trim();
    }

}
